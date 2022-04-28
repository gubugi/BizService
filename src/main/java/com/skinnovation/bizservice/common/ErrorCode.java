package com.skinnovation.bizservice.common;

public enum ErrorCode {
    SUCCESS("E0000") // 성공
    , ERROR("E9999") // 서버에러
    , NO_PERMISSION("E0001") // 접근 권한 없음
    , INVALID_PARAMETER("E0002") // 잘못된 파라미터
    , DATA_NOT_FOUND("E0003") // 데이터 없음
    ;

    public final String code;

    private ErrorCode(String code) {
        this.code = code;
    }

    public boolean equalsCode(String anotherCode) {
        return this.code.equalsIgnoreCase(anotherCode);
    }
}
