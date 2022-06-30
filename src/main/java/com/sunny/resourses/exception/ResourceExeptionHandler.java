package com.sunny.resourses.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sunny.services.excepitions.DataIntegrityExeption;
import com.sunny.services.excepitions.ObejectNotFountExeption;

@ControllerAdvice
public class ResourceExeptionHandler {
	
	@ExceptionHandler(ObejectNotFountExeption.class)
	public ResponseEntity<StandardError> objectNotFound(ObejectNotFountExeption e,HttpServletRequest request) {
	
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityExeption.class)
	public ResponseEntity<StandardError> objectNotFound(DataIntegrityExeption e,HttpServletRequest request) {
	
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
