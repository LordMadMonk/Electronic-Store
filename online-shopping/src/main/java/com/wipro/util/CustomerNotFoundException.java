package com.wipro.util;

public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
