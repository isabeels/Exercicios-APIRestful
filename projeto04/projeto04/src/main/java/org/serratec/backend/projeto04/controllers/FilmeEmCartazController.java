package org.serratec.backend.projeto04.controllers;

import java.util.List;

import org.serratec.backend.projeto04.entities.FilmeEmCartaz;
import org.serratec.backend.projeto04.services.FilmeEmCartazService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class FilmeEmCartazController {

	@Autowired
	FilmeEmCartazService filmeEmCartaz;
	
	@GetMapping("/filmes")
	public List<FilmeEmCartaz> todoCatalogo() {
		return filmeEmCartaz.todoCatalogo();
	}

	@GetMapping("/filmes/{posicaoId}")
	public FilmeEmCartaz getId(@PathVariable int posicaoId, @RequestBody FilmeEmCartaz bodyId) {
		return filmeEmCartaz.getId(posicaoId);
	}

	@PostMapping("/criar")
	public void criar(@RequestBody FilmeEmCartaz bodyId) {
	filmeEmCartaz.criar(bodyId);
	}

	@PutMapping("/atualizar/{posicaoId}")
	public void atualizar(@PathVariable Integer posicaoId,@RequestBody FilmeEmCartaz bodyId) {
	filmeEmCartaz.atualizar(posicaoId, bodyId);	
	}

	@DeleteMapping("/deletar/{posicaoId}")
	public void deletar(@PathVariable int posicaoId) {
		filmeEmCartaz.deletar(posicaoId);
	}
}
