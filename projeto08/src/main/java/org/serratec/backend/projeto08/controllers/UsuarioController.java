package org.serratec.backend.projeto08.controllers;


import java.util.List;


import org.serratec.backend.projeto08.dto.UsuarioDTO;
import org.serratec.backend.projeto08.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/buscar-todos")
	public ResponseEntity<List<UsuarioDTO>> buscarTodos(){
		return ResponseEntity.ok(usuarioService.buscarTodos());
	}
	
	@GetMapping("/buscar/{idUsuario}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer idUsuario) {
		return ResponseEntity.ok(usuarioService.buscarPorId(idUsuario));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Integer> salvar(@RequestBody UsuarioDTO usuarioDTO) {
		return ResponseEntity.ok(usuarioService.salvar(usuarioDTO));
	}
	
	
	
}
