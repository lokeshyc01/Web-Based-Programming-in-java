package com.app.customexception;

public class ResourceNotFound extends RuntimeException {
	public ResourceNotFound(String err)
	{
		super(err);
	}
}
