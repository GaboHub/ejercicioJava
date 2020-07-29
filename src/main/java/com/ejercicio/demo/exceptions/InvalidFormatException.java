package com.ejercicio.demo.exceptions;

public class InvalidFormatException extends RuntimeException implements BusinessException {

    private static final long serialVersionUID = -152825732643633947L;

    private String message;

    public InvalidFormatException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}