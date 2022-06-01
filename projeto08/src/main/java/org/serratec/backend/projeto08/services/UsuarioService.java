package org.serratec.backend.projeto08.services;


import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.projeto08.dto.UsuarioDTO;
import org.serratec.backend.projeto08.entities.UsuarioEntity;
import org.serratec.backend.projeto08.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public UsuarioDTO entityToDTO(UsuarioEntity usuario, UsuarioDTO usuarioDTO) {

		usuarioDTO.setLogin(usuario.getLogin());
		usuarioDTO.setSenha(usuario.getSenha());

		return usuarioDTO;
	}

	public UsuarioEntity dtoToEntity(UsuarioEntity usuario, UsuarioDTO usuarioDTO) {

		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setSenha(usuarioDTO.getSenha());

		return usuario;
	}
	
	public UsuarioDTO buscarPorId(Integer idUsuario) {
		return usuarioRepository.findById(idUsuario)
				.map(usuario -> entityToDTO(usuario, new UsuarioDTO()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<UsuarioDTO> buscarTodos(){
		return usuarioRepository.findAll()
				.stream()
				.map(usuario -> entityToDTO(usuario,new UsuarioDTO()))
				.collect(Collectors.toList());
	}
	
	public UsuarioDTO buscarPorLogin(String login) {
		return usuarioRepository.findAll()
				.stream()
				.filter(usuario -> usuario.getLogin().equals(login))
				.map(usuario -> entityToDTO(usuario,new UsuarioDTO()))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Integer salvar(UsuarioDTO usuarioDTO) {
		UsuarioEntity usuario = new UsuarioEntity();
		dtoToEntity(usuario, usuarioDTO);
		usuarioRepository.save(usuario);
		return usuario.getIdUsuario();
	}
}
