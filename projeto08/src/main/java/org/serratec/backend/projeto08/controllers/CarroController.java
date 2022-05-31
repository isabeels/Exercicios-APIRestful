package org.serratec.backend.projeto08.controllers;

import java.util.List;



import org.serratec.backend.projeto08.dto.CarroDTO;
import org.serratec.backend.projeto08.exceptions.CarroException;
import org.serratec.backend.projeto08.services.CarroService;
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
@RequestMapping ("/carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	@PostMapping("/adicionar")
	public ResponseEntity<String> salvar(@RequestBody CarroDTO clienteDTO) throws CarroException{
		return ResponseEntity.ok(carroService.salvar(clienteDTO));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<CarroDTO>> buscarTodos(){
		return ResponseEntity.ok(carroService.buscarTodos());
	}
	
	@GetMapping("/buscar/{idCarro}")
	public ResponseEntity<CarroDTO> buscarPorId(@PathVariable Integer idCarro) throws CarroException{
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}
	
	@PutMapping("/atualizar/{idCarro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCarro,@RequestBody CarroDTO carroDTO) throws CarroException{
		return ResponseEntity.ok(carroService.atualizar(idCarro, carroDTO));
	}
	
	@DeleteMapping("/deletar/{idCarro}")
	public ResponseEntity<String> deletar(@PathVariable Integer idCarro) throws CarroException {
	return ResponseEntity.ok(carroService.deletar(idCarro));
	}
	
	
	@PostMapping("/adicionar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CarroDTO> listaCarro) {
		carroService.salvarListaCarro(listaCarro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
