package com.ejercicio.demo.controller.exceptionHandler;

import com.ejercicio.demo.exceptions.BusinessException;
import com.ejercicio.demo.exceptions.InvalidFormatException;
import com.ejercicio.demo.exceptions.UserRegisteredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler
  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value
	  = { UserRegisteredException.class, InvalidFormatException.class, Exception.class })
	protected ResponseEntity<Object> handleConflict(
	  RuntimeException ex, WebRequest request) {

		HttpStatus httpStatus;
		ExceptionMessage exceptionMessage;
		if(ex instanceof BusinessException) {
			exceptionMessage = ExceptionMessage.builder()
					.message(ex.getMessage()).build();
			httpStatus = HttpStatus.CONFLICT;
		} else {
			log.error("error", ex);
			exceptionMessage = ExceptionMessage.builder()
					.message("UNKNOWN SERVER ERROR").build();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return handleExceptionInternal(ex, exceptionMessage,
		  new HttpHeaders(), httpStatus, request);
	}
}