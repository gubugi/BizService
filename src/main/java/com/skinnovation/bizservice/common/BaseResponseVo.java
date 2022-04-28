package com.skinnovation.bizservice.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseVo<T> {
    @Schema(description = "상태코드")
    private String status;

    @Schema(description = "메세지")
    private String message;

    @Nullable
    @Schema(description = "에러목록")
    private List<BaseErrorVo> errorList;

    @Nullable
    @Schema(description = "본문")
    private T resultData;
}
