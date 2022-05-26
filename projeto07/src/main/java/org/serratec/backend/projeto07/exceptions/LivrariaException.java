package org.serratec.backend.projeto07.exceptions;

public class LivrariaException extends Exception {

	private static final long serialVersionUID = 1L;

	public LivrariaException() {
		super();
	}
	
	public LivrariaException(String message) {
		super(message);
	}
	

	public LivrariaException(String message, Exception cause) {
		super(message, cause);
	}
	
	public LivrariaException(Exception e) {
		super(e);
	}
	
}
