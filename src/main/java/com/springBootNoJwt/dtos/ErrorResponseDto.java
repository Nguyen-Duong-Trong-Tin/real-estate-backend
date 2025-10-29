package com.springBootNoJwt.dtos;

import java.util.List;

public class ErrorResponseDto {
	private String error;
	private List<String> details;
	
	public ErrorResponseDto(String error, List<String> details) {
		super();
		this.error = error;
		this.details = details;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
}
