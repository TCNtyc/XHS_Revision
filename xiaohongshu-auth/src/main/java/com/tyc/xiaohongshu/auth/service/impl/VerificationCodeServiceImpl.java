package com.tyc.xiaohongshu.auth.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.tyc.xiaohongshu.auth.constant.RedisKeyConstants;
import com.tyc.xiaohongshu.auth.service.VerificationCodeService;
import com.tyc.xiaohongshu.auth.sms.AliyunSmsHelper;
import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.auth.enums.ResponseCodeEnum;
import com.tyc.xiaohongshu.auth.model.vo.verificationcode.SendVerificationCodeReqVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Resource
    private AliyunSmsHelper aliyunSmsHelper;

    @Override
    public Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO) throws BizException {
        String phone = sendVerificationCodeReqVO.getPhone();
        String key = RedisKeyConstants.buildVerificationCodeKey(phone);
        // 判断是否已发送验证码
        boolean isSent = redisTemplate.hasKey(key);
        if (isSent) {
            // 若之前发送的验证码未过期，则提示发送频繁
            throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_SEND_FREQUENTLY);
        }
        String verificationCode = RandomUtil.randomNumbers(6);
        log.info("==> 手机号: {}, 已发送验证码：【{}】", phone, verificationCode);
        redisTemplate.opsForValue().set(key, verificationCode,3, TimeUnit.MINUTES);

        // 调用第三方短信发送服务
        threadPoolTaskExecutor.submit(() -> {
            String signName = "阿里云短信测试";
            String templateCode = "SMS_154950909";
            String templateParam = String.format("{\"code\":\"%s\"}", verificationCode);
            aliyunSmsHelper.sendMessage(signName, templateCode, phone, templateParam);
        });

        // 存储验证码到 redis, 并设置过期时间为 3 分钟
        redisTemplate.opsForValue().set(key, verificationCode, 3, TimeUnit.MINUTES);

        return Response.success();
    }

}
