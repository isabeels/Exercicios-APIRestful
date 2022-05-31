package org.serratec.backendprojeto05.projeto05.controller;


import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backendprojeto05.projeto05.DTO.CartaoDTO;
import org.serratec.backendprojeto05.projeto05.exceptions.CartaoException;
import org.serratec.backendprojeto05.projeto05.exceptions.EmailException;
import org.serratec.backendprojeto05.projeto05.model.Cartao;
import org.serratec.backendprojeto05.projeto05.service.CartaoService;
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
@RequestMapping("/cartao")
public class CartaoController {
	
	
	@Autowired
	CartaoService cartaoService;
	
//	@GetMapping("/leitor")
//	public ResponseEntity<Void> leitor() throws IOException{
//		cartaoService.leitor();
//		return new ResponseEntity<>(HttpStatus.ACCEPTED);
//	}
	
	@PostMapping("")
	public ResponseEntity<Cartao> salvar(@RequestBody Cartao cartao){
		return ResponseEntity.ok(cartaoService.save(cartao));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CartaoDTO cartaoDTO) throws MessagingException, EmailException{
		return ResponseEntity.ok(cartaoService.salvar(cartaoDTO));
	}
	
	@GetMapping("/buscar/{idCartao}")
	public ResponseEntity<CartaoDTO> buscarPorId(@PathVariable Integer idCartao) throws CartaoException{
		return ResponseEntity.ok(cartaoService.buscarPorId(idCartao));
	}
	
	@DeleteMapping("/{idCartao}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCartao){
		cartaoService.deletar(idCartao);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idCartao}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCartao, @RequestBody CartaoDTO cartaoDTO) throws CartaoException{
		return ResponseEntity.ok(cartaoService.atualizar(idCartao, cartaoDTO));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<CartaoDTO>> listarTodos(){
		return ResponseEntity.ok(cartaoService.buscarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CartaoDTO> listaCartaoDTO){
		cartaoService.salvarListaCartao(listaCartaoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}