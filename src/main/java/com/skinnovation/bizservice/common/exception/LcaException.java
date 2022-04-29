package com.skinnovation.bizservice.common.exception;

import com.skinnovation.bizservice.common.entity.ErrorType;

public class LcaException extends RuntimeException {
    private int code;
    private ErrorType errorType;
    private String msgTypCod; //Q : Question, C : Critical, I : Information, E : Exclamation , B : system
    private String msgCaption;

    public LcaException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
        this.code = errorType.getCode();
        this.msgTypCod = "";
        this.msgCaption = "";
    }

    public LcaException(ErrorType errorType, String subMessage) {
        super(errorType.getMessage() + " (" + subMessage + ")");
        this.errorType = errorType;
        this.code = errorType.getCode();
        this.msgTypCod = "";
        this.msgCaption = "";
    }

    public LcaException(String msgTypCod, ErrorType errorType, String subMessage) {
        super(errorType.getMessage() + " (" + subMessage + ")");
        this.errorType = errorType;
        this.code = errorType.getCode();
        this.msgTypCod = msgTypCod;
        this.msgCaption = "";
    }

    public LcaException(String msgTypCod, ErrorType errorType, String subMessage, String msgCaption) {
        super(errorType.getMessage() + " (" + subMessage + ")");
        this.errorType = errorType;
        this.code = errorType.getCode();
        this.msgTypCod = msgTypCod;
        this.msgCaption = msgCaption;
    }

    public LcaException(String errorType) {
        super(errorType);
        this.errorType = ErrorType.UNKNOWN;
        this.code = 99999;
        this.msgTypCod = "";
        this.msgCaption = "";
    }

    public int getCode() {
        return code;
    }
    public String getMsgTypCod() {
        return msgTypCod;
    }
    public String getMsgCaption() {
        return msgCaption;
    }
    public ErrorType getErrorType() {
        return this.errorType;
    }

}
