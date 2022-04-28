package com.skinnovation.bizservice.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class BaseErrorVo {
    @Schema(description = "Error Code")
    private String errCd;

    @Schema(description = "Error Message")
    private String errMsg;
}
