package com.favmovie.exceptions;

public class ErrorMessage {
    private final String exception;
    private final String status;
    private final String message;

    public ErrorMessage(String exception, String status, String message) {
        this.exception = exception;
        this.status = status;
        this.message = message;
    }
}
