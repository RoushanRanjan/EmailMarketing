package com.nacre.emailmarketing.exception;



public class DatabaseException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DatabaseException() {
	}
	
	public DatabaseException( String message) {
		
		super(message);
	}

}