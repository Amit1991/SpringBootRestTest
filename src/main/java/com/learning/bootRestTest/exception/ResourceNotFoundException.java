package com.learning.bootRestTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter @Setter @ToString
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -415178896756495553L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
