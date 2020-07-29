package com.ejercicio.demo.exceptions;

public class UserRegisteredException extends RuntimeException {

    private static final long serialVersionUID = -152825732643633947L;

    public UserRegisteredException(String message) {
        super(message);
    }
}
