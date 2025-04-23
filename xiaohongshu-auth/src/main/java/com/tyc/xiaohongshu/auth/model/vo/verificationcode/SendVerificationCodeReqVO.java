package com.tyc.xiaohongshu.auth.model.vo.verificationcode;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SendVerificationCodeReqVO {

    @NotBlank(message = "手机号不能为空")
    private String phone;
}