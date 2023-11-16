package com.codewithabdul.blog.exceptions;

import java.util.HashMap;

import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithabdul.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	
	public ResponseEntity<ApiResponse>resourceNotFounExceptionHandler(ResourceNotFoundException ex){
		
		String massage=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse();
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND); 
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<java.util.Map<String,String>> resourceNotFoundExceptionHandler(MethodArgumentNotValidException ex){
		
		java.util.Map<String,String>resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			 String fieldName=((FieldError)error).getField();
			 String message=error.getDefaultMessage();
			 resp.put(fieldName, message);
			
		});
		
		
		
		return new ResponseEntity<java.util.Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
		
		
		
		
	}
	
		
		
		
	

}
