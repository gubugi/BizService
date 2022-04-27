package com.skinnovation.bizservice.service.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사용자 정보")
public class UserReqVo {
    @Schema(description = "사용자아이디")
    private String userId;
    @Schema(description = "사용자암호")
    private String userPw;
    @Schema(description = "사용자암호", accessMode = Schema.AccessMode.READ_ONLY)
    private String userCryptoPw;
    @Schema(description = "사용자이름")
    private String userNm;
    @Schema(description = "사용자이메일")
    private String userEmail;
    @Schema(description = "소속회사코드")
    private String userCorpCd;
    @Schema(description = "사용자권한")
    private String userRole;
}
