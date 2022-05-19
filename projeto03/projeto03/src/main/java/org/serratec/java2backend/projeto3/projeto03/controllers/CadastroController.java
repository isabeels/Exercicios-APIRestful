package org.serratec.java2backend.projeto3.projeto03.controllers;

import java.util.List;

import org.serratec.java2backend.projeto3.projeto03.entities.Cadastro;
import org.serratec.java2backend.projeto3.projeto03.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroController {

	@Autowired
	CadastroService cadastroService;

	@RequestMapping ("/cadastro")
	public List<Cadastro> getLista() {
		return cadastroService.listaCadastro();
	}

}
