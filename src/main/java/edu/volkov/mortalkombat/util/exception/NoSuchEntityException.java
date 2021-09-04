package edu.volkov.mortalkombat.util.exception;

import lombok.Getter;

public class NoSuchEntityException extends RuntimeException {

    @Getter
    private final String errMessage;

    public NoSuchEntityException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }
}
