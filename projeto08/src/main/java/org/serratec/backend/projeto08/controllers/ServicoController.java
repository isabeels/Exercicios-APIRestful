package org.serratec.backend.projeto08.controllers;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.projeto08.dto.RelatorioDTO;
import org.serratec.backend.projeto08.dto.ServicoDTO;
import org.serratec.backend.projeto08.exceptions.EmailException;
import org.serratec.backend.projeto08.exceptions.ServicoException;
import org.serratec.backend.projeto08.services.ServicoService;
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
@RequestMapping ("/servico")
public class ServicoController {

	@Autowired
	ServicoService servicoService;
	
	@PostMapping("/adicionar")
	public ResponseEntity<String> salvar(@RequestBody ServicoDTO servicoDTO) throws ServicoException, MessagingException, EmailException{
		return ResponseEntity.ok(servicoService.salvar(servicoDTO));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ServicoDTO>> buscarTodos(){
		return ResponseEntity.ok(servicoService.buscarTodos());
	}
	
	@GetMapping("/buscar/{idServico}")
	public ResponseEntity<ServicoDTO> buscarPorId(@PathVariable Integer idServico) throws ServicoException{
		return ResponseEntity.ok(servicoService.buscarPorId(idServico));
	}
	
	@PutMapping("/atualizar/{idServico}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idServico,@RequestBody ServicoDTO servicoDTO) throws ServicoException{
		return ResponseEntity.ok(servicoService.atualizar(idServico, servicoDTO));
	}
	
	@DeleteMapping("/deletar/{idServico}")
	public ResponseEntity<String> deletar(@PathVariable Integer idServico) throws ServicoException {
	return ResponseEntity.ok(servicoService.deletar(idServico));
	}
	
	
	@PostMapping("/adicionar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<ServicoDTO> listaServico) {
		servicoService.salvarListaServico(listaServico);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/relatorio")
	public ResponseEntity<List<RelatorioDTO>> relatorio (){
		return ResponseEntity.ok(servicoService.relatorio());
	}
}
