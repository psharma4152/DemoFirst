package com.example.SpringBootA.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<Object> handleCityNotFoundException(CityNotFoundException e, Request r){
		
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("timestamp", LocalDateTime.now());
		data.put("reason", "No City With Such Id");
		
		
		return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException e, Request r){
		
		HashMap<String, Object> data = new LinkedHashMap<>();
		data.put("timestamp", LocalDateTime.now());
		data.put("reason", "No Data Available for the Cities");
		
		return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
	}
	

}
