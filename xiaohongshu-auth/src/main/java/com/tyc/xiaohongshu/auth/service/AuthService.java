package com.tyc.xiaohongshu.auth.service;

import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.auth.model.vo.user.UpdatePasswordReqVO;
import com.tyc.xiaohongshu.auth.model.vo.user.UserLoginReqVO;


public interface AuthService {
    /**
     * 修改密码
     * @param updatePasswordReqVO
     * @return
     */
    Response<?> updatePassword(UpdatePasswordReqVO updatePasswordReqVO);

    /**
     * 退出登录
     * @return
     */
    Response<?> logout();
    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO) throws BizException;
}