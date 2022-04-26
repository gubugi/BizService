package com.skinnovation.bizservice.service.sample.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class SampleReqVo {
    @ApiModelProperty(value = "사용자번호")
    private Long userNo;
    @ApiModelProperty(value = "사용자아이디", required = true)
    private String userId;
    @ApiModelProperty(value = "사용자암호", required = true)
    private String userPw;
    @ApiModelProperty(value = "사용자이름", required = true)
    private String userNm;
    @ApiModelProperty(value = "이메일")
    private String userEmail;
    @ApiModelProperty(value = "소속회사코드")
    private String userCorpCd;
}
