package org.serratec.backend.projeto06.controllers;

import java.util.List;

import org.serratec.backend.projeto06.entities.ContaBancaria;
import org.serratec.backend.projeto06.exceptions.ContaBancariaException;
import org.serratec.backend.projeto06.service.ContaBancariaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaBancariaController {

	@Autowired
	ContaBancariaService contaBancariaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ContaBancaria>> findAll(){
		return ResponseEntity.ok(contaBancariaService.findAll());
	}
	
	@GetMapping("/acessar/{idConta}")
	public ResponseEntity<ContaBancaria> findById(@PathVariable Integer idConta){
		return ResponseEntity.ok(contaBancariaService.findById(idConta));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> criar(@RequestBody ContaBancaria conta){
		contaBancariaService.adicionar(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/adicionarVariasContas")
	public ResponseEntity<Void> criarContas(@RequestBody List<ContaBancaria> conta){
		contaBancariaService.adicionarListaContas(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/atualizar/{idConta}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idConta, @RequestBody ContaBancaria conta){
		contaBancariaService.atualizar(idConta, conta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deletar/{idConta}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idConta){
		contaBancariaService.deletar(idConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{idConta}/operacao")
	public ResponseEntity<Void> operacao(
			@PathVariable Integer idConta,
			@RequestParam String operacao,
			@RequestParam Double valorParam) throws ContaBancariaException{
		contaBancariaService.operacao(idConta, operacao, valorParam);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
