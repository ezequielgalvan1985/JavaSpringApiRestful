package com.elementary.spring.mvc.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp = new Date();
	private String message;
	private String details;
	private int status;
	public ExceptionResponse(){};
	public ExceptionResponse(int status,String message, String details) {
		super();
		this.message = message;
		this.details = details;
		this.status  = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
