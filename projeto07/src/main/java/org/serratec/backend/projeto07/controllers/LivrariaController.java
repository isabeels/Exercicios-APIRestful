package org.serratec.backend.projeto07.controllers;

import java.util.List;

import org.serratec.backend.projeto07.dto.LivrariaDTO;
import org.serratec.backend.projeto07.entities.Livraria;
import org.serratec.backend.projeto07.exceptions.LivrariaException;
import org.serratec.backend.projeto07.services.LivrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/livraria")
public class LivrariaController {

	@Autowired 
	LivrariaService livrariaService;

	
	@GetMapping ("/listar")
	public ResponseEntity<List<LivrariaDTO>> buscarTodos(){
		return ResponseEntity.ok(livrariaService.buscarTodos());
	}

	@GetMapping ("/buscar/{livroId}")
	public ResponseEntity<LivrariaDTO> buscarPorId (@PathVariable Integer livroId) throws LivrariaException {
		return ResponseEntity.ok(livrariaService.buscarPorId(livroId));
	}
	
	@PostMapping ("/adicionar")
	public ResponseEntity<Livraria> adicionarNovo (@RequestBody LivrariaDTO livrariaDTO) throws LivrariaException {
		return ResponseEntity.ok(livrariaService.adicionarNovo(livrariaDTO));
	}
	
	@PostMapping ("/adicionar-lista")
	public ResponseEntity<Void> adicionarLista(@RequestBody List<LivrariaDTO> livrosDTO) throws LivrariaException{
		livrariaService.adicionarLista(livrosDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}

	@PutMapping ("/atualizar/{livroId}")
	public ResponseEntity<String> atualizar (@RequestBody LivrariaDTO livrariaDTO, @PathVariable Integer livroId) throws LivrariaException{
	return ResponseEntity.ok(livrariaService.atualizar(livrariaDTO, livroId));
	}
	
	@DeleteMapping ("/deletar/{idLivro}")
	public ResponseEntity<Void> deletar (@PathVariable Integer idLivro){
		livrariaService.deletar(idLivro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}




}

