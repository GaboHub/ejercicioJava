package com.ejercicio.demo.controller.exceptionHandler;

import com.ejercicio.demo.exceptions.InvalidFormatException;
import com.ejercicio.demo.exceptions.UserRegisteredException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value
	  = { UserRegisteredException.class, InvalidFormatException.class })
	protected ResponseEntity<Object> handleConflict(
	  RuntimeException ex, WebRequest request) {

		ExceptionMessage exceptionMessage = ExceptionMessage.builder().message(ex.getMessage()).build();
		return handleExceptionInternal(ex, exceptionMessage,
		  new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}