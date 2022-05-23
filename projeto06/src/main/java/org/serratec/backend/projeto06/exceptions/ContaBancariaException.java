package org.serratec.backend.projeto06.exceptions;

public class ContaBancariaException extends Exception {

private static final long serialVersionUID = 1L;
	
	public ContaBancariaException(String message) {
		super(message);
	}
	
	public ContaBancariaException() {}
}
