package com.skinnovation.bizservice.common.exception;

import com.skinnovation.bizservice.common.entity.ErrorType;
import com.skinnovation.bizservice.common.entity.CodeVo;

import java.util.ArrayList;
import java.util.List;

public class ServerErrorResponse {

    private int code;
    private int status;
    private String message;
    private String msgTypCod;
    private String msgCaption;
    private List<CodeVo> errorList = new ArrayList<>();


    public ServerErrorResponse(LcaException ge) {
        this.code = ge.getCode();
        this.status = this.code;
        this.message = ge.getMessage();
    }

    public ServerErrorResponse(ErrorType errorType) {
        this.code = errorType.getCode();
        this.status = this.code;
        this.message = errorType.getMessage();
    }

    public ServerErrorResponse(ErrorType errorType, String message) {
        this.code = errorType.getCode();
        this.status = this.code;
        this.message = message;
    }

    public ServerErrorResponse(String msgTypCod, ErrorType errorType, String message) {
        this.code = errorType.getCode();
        this.status = this.code;
        this.message = message;
        this.msgTypCod = msgTypCod;
    }

    public ServerErrorResponse(ErrorType errorType, List<CodeVo> errorList, String message) {
        this.code = errorType.getCode();
        this.status = this.code;
        this.message = message;
        this.errorList = errorList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getMsgTypCod() {return msgTypCod;}
    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {return status;}

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CodeVo> getErrorList() {
        return this.errorList;
    }
}
