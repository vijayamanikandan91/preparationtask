package com.myapp.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptions {
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> nameNotFoundHandling(NameNotFoundException ne){
		return new ResponseEntity<> (ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AgeNotAvailableException.class)
	public ResponseEntity<Object> ageNotAvailableHandles(AgeNotAvailableException ae){
		return new ResponseEntity<> (ae.getMessage(),HttpStatus.NOT_FOUND);
		
	}

}
