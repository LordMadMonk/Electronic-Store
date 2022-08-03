package com.ibm.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> allExceptionhandler(Exception ex){
		String details = ex.getLocalizedMessage();
		ApiException error = new ApiException(details,ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
