package org.serratec.backend.projeto06.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ContaBancariaException.class)
	public ResponseEntity<String> trataContaNotFound(ContaBancariaException exception){
		String msgException = String.format("Saldo insuficiente");
		return ResponseEntity.notFound()
				.header("x-erro-msg", msgException)
				.header("x-erro-code", "BAD REQUEST")
				.build();
	}
	
}
