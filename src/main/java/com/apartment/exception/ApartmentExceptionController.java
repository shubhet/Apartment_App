package com.apartment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApartmentExceptionController {

	@ExceptionHandler(value = ApartmentNotFountException.class)
	public ResponseEntity<Object> exceptionHandle(ApartmentNotFountException exception) {
		return new ResponseEntity<>("Apartment Not Found in the Database", HttpStatus.NOT_FOUND);

	}
}
