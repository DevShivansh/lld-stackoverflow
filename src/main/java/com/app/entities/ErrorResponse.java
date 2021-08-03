package com.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	private HttpStatus status;
	
	private LocalDateTime time;

	public ErrorResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
		time = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	
	
}
