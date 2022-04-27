package com.skinnovation.bizservice.service.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginVo {
    @Schema(description = "사용자아이디")
    private String userId;
    @Schema(description = "사용자암호")
    private String userPw;
}
