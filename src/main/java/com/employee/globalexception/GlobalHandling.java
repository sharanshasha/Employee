package com.employee.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.coustomexception.IdAlreadyInException;
import com.employee.coustomexception.SalaryNetValueException;

@RestControllerAdvice

public class GlobalHandling {
	@ExceptionHandler(IdAlreadyInException.class)
	
	public ResponseEntity<Object> idHandling() {
		return new ResponseEntity<> ("Its not a valid Id", HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(SalaryNetValueException.class)
	
	public ResponseEntity<Object> salHandling() {
		return new ResponseEntity<> ("Its not Valid", HttpStatus.BAD_REQUEST);
	}
	
}
