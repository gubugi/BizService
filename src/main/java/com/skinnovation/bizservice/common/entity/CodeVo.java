package com.skinnovation.bizservice.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CodeVo {
    private String key;
    private String value;

    public CodeVo(){}

    public CodeVo(String key, String value){
        this.key = key;
        this.value = value;
    }
}
