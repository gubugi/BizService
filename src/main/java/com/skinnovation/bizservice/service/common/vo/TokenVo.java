package com.skinnovation.bizservice.service.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TokenVo {
    @Schema(description = "사용자 아이디")
    private String userId;
    @Schema(description = "사용자 Token")
    private String userToken;
    @Schema(description = "Token 발행시간")
    private Date issuedAt;
}
