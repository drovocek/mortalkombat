package edu.volkov.mortalkombat.util.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    DATA_NOT_FOUND("Data not found", HttpStatus.UNPROCESSABLE_ENTITY);

    private final String errorCode;
    private final HttpStatus status;

    ErrorType(String errorCode, HttpStatus status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
