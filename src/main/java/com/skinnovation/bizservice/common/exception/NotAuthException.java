package com.skinnovation.bizservice.common.exception;

import com.skinnovation.bizservice.common.entity.ErrorType;

public class NotAuthException extends LcaException {
    public NotAuthException() {
        super(ErrorType.NOT_AUTH);
    }
}
