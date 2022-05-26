package org.serratec.backend.projeto07.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.serratec.backend.projeto07.dto.LivrariaDTO;
import org.serratec.backend.projeto07.entities.Livraria;
import org.serratec.backend.projeto07.exceptions.LivrariaException;
import org.serratec.backend.projeto07.repositories.LivrariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LivrariaService {
	
	@Autowired
	LivrariaRepository livrariaRepository;
	
	public LivrariaDTO entityToDTO (LivrariaDTO livrariaDTO, Livraria livraria) {
		
		livrariaDTO.setIdLivro(livraria.getIdLivro());
		livrariaDTO.setTituloLivro(livraria.getTituloLivro());
		livrariaDTO.setTipoLivro(livraria.getTipoLivro());
		livrariaDTO.setAutorLivro(livraria.getAutorLivro());
		livrariaDTO.setDataPublicacao(livraria.getDataPublicacao());
		
		return livrariaDTO;
	}
	
	public Livraria dtoToEntity (LivrariaDTO livrariaDTO, Livraria livraria) throws LivrariaException {
		
		if (livrariaDTO.getTituloLivro()== null)
			throw new LivrariaException("Título do livro não informado");
		
		if(livrariaDTO.getTipoLivro() == null)
			throw new LivrariaException("Tipo do livro não informado");
		
		if(livrariaDTO.getDataPublicacao() == null)
			throw new LivrariaException("Data da publicação do livro não informado");
	
		if(livrariaDTO.getAutorLivro() == null)
			throw new LivrariaException("Autor do livro não informado");
		
		livraria.setTituloLivro(livrariaDTO.getTituloLivro());
		livraria.setAutorLivro(livrariaDTO.getAutorLivro());
		livraria.setDataPublicacao(livrariaDTO.getDataPublicacao());
		livraria.setTipoLivro(livrariaDTO.getTipoLivro());
		
		return livraria;
	}

	//GET - TODOS
	
	public List<LivrariaDTO> buscarTodos(){
		
		List<Livraria> lista = livrariaRepository.findAll();
		List<LivrariaDTO> listaDTO = new ArrayList<>();
		
		for(Livraria livraria : lista) {
			LivrariaDTO livrariaDTO = new LivrariaDTO();
			entityToDTO(livrariaDTO, livraria);
			listaDTO.add(livrariaDTO);
		}
		return listaDTO;
			
	}
	
	//GET - POR ID
	
	public LivrariaDTO buscarPorId(Integer livroId) throws LivrariaException {
		Optional<Livraria> livro = livrariaRepository.findById(livroId);
		
		if(livro.isPresent()) {
			
			Livraria livroPorId = new Livraria();
			LivrariaDTO livrariaDTO = new LivrariaDTO();
			
			livroPorId = livro.get();
			entityToDTO(livrariaDTO, livroPorId);
			
			return livrariaDTO;
		}
		
		throw new LivrariaException ("O id informado não existe");
	}
	
	//POST
	
		public Livraria adicionarNovo(LivrariaDTO livrariaDTO) throws LivrariaException {
			
			Livraria livraria = new Livraria();
			Livraria livroNovo = new Livraria();
			
			livroNovo = dtoToEntity(livrariaDTO, livraria);
			
			return livrariaRepository.save(livroNovo);
		}
	
	//POST - LISTA
		
		public void adicionarLista(List<LivrariaDTO> livrosDTO) throws LivrariaException {
			
			for(LivrariaDTO livrariaDTO : livrosDTO) {
				Livraria livraria = new Livraria();
				dtoToEntity(livrariaDTO, livraria);
				livrariaRepository.save(livraria);
			}
		}
		
	//PUT - POR ID
	
	public String atualizar(LivrariaDTO livroDTO, Integer livroId) throws LivrariaException {
		Optional<Livraria> livro = livrariaRepository.findById(livroId);
		Livraria livroAtualizado = new Livraria();
		
		if(livro.isPresent()) {
			
		livroAtualizado = livro.get();
			
			if(livroDTO.getTituloLivro() != null) {
				livroAtualizado.setTituloLivro(livroDTO.getTituloLivro());				
			}
			if(livroDTO.getAutorLivro() != null) {
				livroAtualizado.setAutorLivro(livroDTO.getAutorLivro());
			}
			if(livroDTO.getTipoLivro() != null) {
				livroAtualizado.setTipoLivro(livroDTO.getTipoLivro());
			}
			if(livroDTO.getDataPublicacao() != null) {
				livroAtualizado.setDataPublicacao(livroDTO.getDataPublicacao());
			}
			
			livrariaRepository.save(livroAtualizado);
			return "O livro " + livroAtualizado.getTituloLivro() +" foi atualizado";
			
		}
		throw new LivrariaException ("Não foi possível atualizar este livro");
		
	}
	
	// DELETE - POR ID
		
	public void deletar(Integer idLivro) {
		livrariaRepository.deleteById(idLivro);
	}

}
