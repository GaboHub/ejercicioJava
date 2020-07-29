package com.ejercicio.demo.controller.exceptionHandler;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class ExceptionMessage implements Serializable {

    private static final long serialVersionUID = 1292152018820907384L;
    private final String message;

}
