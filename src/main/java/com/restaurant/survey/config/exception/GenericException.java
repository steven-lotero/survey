package com.restaurant.survey.config.exception;


import com.restaurant.survey.config.ErrorMessage;

public abstract class GenericException extends RuntimeException {

    private final ErrorMessage errorMessage;

    protected GenericException(ErrorMessage errorCode) {
        super(errorCode.getReasonPhrase());
        this.errorMessage = errorCode;
    }

    public ErrorMessage getCode() {
        return this.errorMessage;
    }
}
