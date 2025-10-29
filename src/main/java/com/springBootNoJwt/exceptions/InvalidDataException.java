package com.springBootNoJwt.exceptions;

public class InvalidDataException extends RuntimeException {
	public static final long serialVersionUID = 1;
	
	public InvalidDataException(String message) {
		super(message);
	}
}
