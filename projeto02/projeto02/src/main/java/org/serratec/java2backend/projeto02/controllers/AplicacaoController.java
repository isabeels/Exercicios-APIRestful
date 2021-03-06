package org.serratec.java2backend.projeto02.controllers;

import org.serratec.java2backend.projeto02.dominio.AplicacaoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AplicacaoController {

	@Autowired
	private AplicacaoConfig aplicacaoConfig;
	
	@GetMapping("/config")
	public AplicacaoConfig retornarConfig() {
		return aplicacaoConfig;
	}
}
