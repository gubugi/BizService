package com.skinnovation.bizservice.service.sample.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "사용자 등록정보", title = "제목")
public class SampleAddVo {
    @Schema(description = "사용자아이디")
    private String userId;
    @Schema(description = "사용자암호")
    private String userPw;
    @Schema(description = "사용자이름")
    private String userNm;
    @Schema(description = "사용자이메일")
    private String userEmail;
    @Schema(description = "소속회사코드")
    private String userCorpCd;
    @Schema(description = "사용자권한")
    private String userRole;
}
