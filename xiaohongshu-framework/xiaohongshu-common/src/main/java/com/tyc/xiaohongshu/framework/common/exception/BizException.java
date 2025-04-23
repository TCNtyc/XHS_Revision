package com.tyc.xiaohongshu.framework.common.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BizException extends Exception implements BaseExceptionInterface  {
    private String errorCode;
    private String errorMessage;
    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
