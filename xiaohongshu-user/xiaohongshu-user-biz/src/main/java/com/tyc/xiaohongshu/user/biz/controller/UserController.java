package com.tyc.xiaohongshu.user.biz.controller;

import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;
import com.tyc.xiaohongshu.user.biz.service.UserService;
import com.tyc.xiaohongshu.framework.common.aspect.ApiOperationLog;
import com.tyc.xiaohongshu.user.dto.req.FindUserByIdReqDTO;
import com.tyc.xiaohongshu.user.dto.req.FindUserByPhoneReqDTO;
import com.tyc.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import com.tyc.xiaohongshu.user.dto.req.UpdateUserPasswordReqDTO;
import com.tyc.xiaohongshu.user.dto.resp.FindUserByIdRspDTO;
import com.tyc.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户信息修改
     *
     * @param updateUserInfoReqVO
     * @return
     */
    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response<?> updateUserInfo(@Validated UpdateUserInfoReqVO updateUserInfoReqVO) throws BizException {
        return userService.updateUserInfo(updateUserInfoReqVO);
    }

    @PostMapping("/register")
    @ApiOperationLog(description = "用户注册")
    public Response<Long> register(@Validated @RequestBody RegisterUserReqDTO registerUserReqDTO) {
        return userService.register(registerUserReqDTO);
    }

    @PostMapping("/password/update")
    @ApiOperationLog(description = "密码更新")
    public Response<?> updatePassword(@Validated @RequestBody UpdateUserPasswordReqDTO updateUserPasswordReqDTO) {
        return userService.updatePassword(updateUserPasswordReqDTO);
    }

    @PostMapping("/findByPhone")
    @ApiOperationLog(description = "手机号查询用户信息")
    public Response<FindUserByPhoneRspDTO> findByPhone(@Validated @RequestBody FindUserByPhoneReqDTO findUserByPhoneReqDTO) throws BizException {
        return userService.findByPhone(findUserByPhoneReqDTO);
    }

    @PostMapping("/findById")
    @ApiOperationLog(description = "查询用户信息")
    public Response<FindUserByIdRspDTO> findById(@Validated @RequestBody FindUserByIdReqDTO findUserByIdReqDTO) throws BizException {
        return userService.findById(findUserByIdReqDTO);
    }

}