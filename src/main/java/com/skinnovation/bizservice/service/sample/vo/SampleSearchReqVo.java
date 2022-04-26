package com.skinnovation.bizservice.service.sample.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleSearchReqVo {
    @ApiModelProperty(value = "사용자번호")
    private Long userNo;
    @ApiModelProperty(value = "사용자아이디")
    private String userId;
    @ApiModelProperty(value = "사용자이름")
    private String userNm;
    @ApiModelProperty(value = "이메일")
    private String userEmail;
    @ApiModelProperty(value = "소속회사코드")
    private String userCorpCd;
}
