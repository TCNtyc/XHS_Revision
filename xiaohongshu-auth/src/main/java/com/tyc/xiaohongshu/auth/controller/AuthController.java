package com.tyc.xiaohongshu.auth.controller;

import com.tyc.xiaohongshu.auth.alarm.AlarmInterface;
import com.tyc.xiaohongshu.auth.service.AuthService;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.framework.common.aspect.ApiOperationLog;
import com.tyc.xiaohongshu.auth.model.vo.user.UpdatePasswordReqVO;
import com.tyc.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@RestController
@Slf4j
public class AuthController {

    @Resource
    private AuthService authService;
    @Resource
    private AlarmInterface alarm;

    @GetMapping("/alarm")
    public String sendAlarm() {
        alarm.send("系统出错啦，犬小哈这个月绩效没了，速度上线解决问题！");
        return "alarm success";
    }

    @SneakyThrows
    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录/注册")
    public Response<String> loginAndRegister(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        return authService.loginAndRegister(userLoginReqVO);
    }


    @PostMapping("/password/update")
    @ApiOperationLog(description = "修改密码")
    public Response<?> updatePassword(@Validated @RequestBody UpdatePasswordReqVO updatePasswordReqVO) {
        return authService.updatePassword(updatePasswordReqVO);
    }


    @PostMapping("/logout")
    @ApiOperationLog(description = "账号登出")
    public Response<?> logout() {
        return authService.logout();
    }
}