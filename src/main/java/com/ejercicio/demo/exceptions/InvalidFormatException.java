package com.ejercicio.demo.exceptions;

public class InvalidFormatException extends RuntimeException {

    private static final long serialVersionUID = -152825732643633947L;

    public InvalidFormatException(String message) {
        super(message);
    }
}