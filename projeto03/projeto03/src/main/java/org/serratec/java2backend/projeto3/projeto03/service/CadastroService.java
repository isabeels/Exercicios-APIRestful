package org.serratec.java2backend.projeto3.projeto03.service;

import java.util.Arrays;
import java.util.List;

import org.serratec.java2backend.projeto3.projeto03.entities.Cadastro;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

	private List<Cadastro> usuarios = Arrays.asList(new Cadastro(1, "Isabel", "Ensino Superior"),
			new Cadastro(2, "Amanda", "Ensino Médio"), new Cadastro(3, "Fabio", "Ensino Fundamental"));

	public List<Cadastro> listaCadastro() {
		return this.usuarios;
	}
}
