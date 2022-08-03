package com.ibm.util;

import java.time.ZonedDateTime;

public class ApiException {
	private final String message;
	private final ZonedDateTime timestamp;
	public ApiException(String message, ZonedDateTime timestamp) {
		super();
		this.message = message;
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
}
