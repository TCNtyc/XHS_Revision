package com.tyc.xiaohongshu.auth.controller;

import com.tyc.xiaohongshu.auth.model.vo.verificationcode.SendVerificationCodeReqVO;
import com.tyc.xiaohongshu.auth.service.VerificationCodeService;
import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.aspect.ApiOperationLog;
import com.tyc.xiaohongshu.framework.common.response.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class VerificationCodeController {
    @Resource
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification/code/send")
    @ApiOperationLog
    public Response<?> send(@RequestBody @Validated SendVerificationCodeReqVO sendVerificationCodeReqVO) throws BizException {
        return verificationCodeService.send(sendVerificationCodeReqVO);
    }
}