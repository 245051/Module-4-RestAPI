package com.example.practice.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

//@ExceptionHandler(BlogException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BlogException extends Exception {
	public BlogException(String message) {
		super(message);
	}

}
