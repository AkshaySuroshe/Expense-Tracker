package com.expenseTracker.AllExeptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.expenseTracker.error.ExceptionMsg;
import com.expenseTracker.exceptions.Exceptions;

@RestControllerAdvice
public class AllExeptionHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionMsg> invalidEmail(Exceptions exceptions)
	{
		ExceptionMsg exceptionMsg = new ExceptionMsg(exceptions.getMessage());
		return new ResponseEntity<ExceptionMsg>(exceptionMsg,HttpStatus.ACCEPTED.NOT_ACCEPTABLE);
	}
	
}//class
