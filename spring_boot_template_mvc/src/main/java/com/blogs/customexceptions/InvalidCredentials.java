package com.blogs.customexceptions;

public class InvalidCredentials extends RuntimeException {
	public InvalidCredentials(String mesg) {
		super(mesg);
	}

}
