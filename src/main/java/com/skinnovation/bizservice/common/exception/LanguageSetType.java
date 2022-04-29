package com.skinnovation.bizservice.common.exception;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public enum LanguageSetType {
//    LANGUAGE_SET_EN("EN", "message_en.properties", "err_message_en.properties"),
    LANGUAGE_SET_KR("KR", "message_kr.properties", "err_message_kr.properties");

    private final String set;
    private final String propertyPath;
    private final String errPropertyPath;

    LanguageSetType(String set, String propertyPath, String errPropertyPath){
        this.set	= set;
        this.propertyPath = propertyPath;
        this.errPropertyPath = errPropertyPath;
    }

    public String getSet() {return this.set;}
    public String getPropertyPath() {return this.propertyPath;}
    public String getErrPropertyPath() {return this.errPropertyPath;}

    public static LanguageSetType from(String set) {
        for(LanguageSetType each : LanguageSetType.values()) {
            if(each.getSet().equals(set)) {
                return each;
            }
        }
        return LanguageSetType.LANGUAGE_SET_KR;
    }

    public HashMap<String, Object> getMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("errPropertyPath", this.getErrPropertyPath());
        map.put("propertyPath", this.getPropertyPath());
        map.put("set", this);
        return map;
    }

    public static List<HashMap<String, Object>> getList(){
        return Arrays.stream(LanguageSetType.values()).map(t -> t.getMap()).collect(Collectors.toList());
    }

}
