package com.ecommerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handleCnfe(ResourceNotFoundException rnfe){
		
		ExceptionInfo info  = new ExceptionInfo();
		info.setCode("Exce101");
		info.setMsg(rnfe.getMessage());
		info.setDate(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionInfo>(info, HttpStatus.BAD_REQUEST);
	}
}
