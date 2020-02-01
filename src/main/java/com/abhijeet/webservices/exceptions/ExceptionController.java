package com.abhijeet.webservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	boolean status = false;

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<String> exception(CustomException exception) {
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
}
