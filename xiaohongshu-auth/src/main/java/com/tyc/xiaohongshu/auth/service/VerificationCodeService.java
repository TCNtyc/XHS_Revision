package com.tyc.xiaohongshu.auth.service;

import com.tyc.xiaohongshu.framework.common.exception.BizException;
import com.tyc.xiaohongshu.framework.common.response.Response;
import com.tyc.xiaohongshu.auth.model.vo.verificationcode.SendVerificationCodeReqVO;

public interface VerificationCodeService {
    Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO) throws BizException;
}
