package com.spring.cruddemo.error;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
