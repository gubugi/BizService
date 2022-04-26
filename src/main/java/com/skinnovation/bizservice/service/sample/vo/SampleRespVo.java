package com.skinnovation.bizservice.service.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Getter
@Setter
@Schema(description = "사용자 정보")
public class SampleRespVo {
    @Schema(description = "사용자번호", defaultValue = "0")
    private Long userNo;
    @Schema(description = "사용자아이디")
    private String userId;
    @Schema(description = "사용자암호", accessMode = READ_ONLY)
    private String userPw;
    @Schema(description = "사용자이름")
    private String userNm;
    @Schema(description = "사용자이메일")
    private String userEmail;
    @Schema(description = "소속회사코드")
    private String userCorpCd;
    @Schema(description = "등록일자")
    private String createAt;
    @Schema(description = "최종수정일자")
    private String updateAt;
}
