package org.serratec.backend.projeto08.controllers;

import java.util.List;

import org.serratec.backend.projeto08.dto.ClienteDTO;
import org.serratec.backend.projeto08.exceptions.ClienteException;
import org.serratec.backend.projeto08.services.ClienteService;
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
@RequestMapping ("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/adicionar")
	public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) throws ClienteException{
		return ResponseEntity.ok(clienteService.salvar(clienteDTO));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteDTO>> buscarTodos(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException{
		return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
	}
	
	@PutMapping("/atualizar/{idCliente}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCliente,@RequestBody ClienteDTO clienteDTO) throws ClienteException{
		return ResponseEntity.ok(clienteService.atualizar(idCliente, clienteDTO));
	}
	
	@DeleteMapping("/deletar/{idCliente}")
	public ResponseEntity<String> deletar(@PathVariable Integer idCliente) throws ClienteException {
	return ResponseEntity.ok(clienteService.deletar(idCliente));
	}
	
	
	@PostMapping("/adicionar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<ClienteDTO> listaCliente) {
		clienteService.salvarListaCliente(listaCliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
