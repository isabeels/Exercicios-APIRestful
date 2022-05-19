package org.serratec.backend.projeto04.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto04.entities.FilmeEmCartaz;
import org.springframework.stereotype.Service;


@Service
public class FilmeEmCartazService {

	List<FilmeEmCartaz> catalogo = new ArrayList<>();

	public List<FilmeEmCartaz> todoCatalogo() {
		return this.catalogo;
	}
	
	public FilmeEmCartaz getId(int posicaoId) {
		return catalogo.get(posicaoId);
	}

	public void criar(FilmeEmCartaz bodyId) {
		catalogo.add(bodyId);
	}

	public void atualizar(Integer posicaoId, FilmeEmCartaz bodyId) {

		FilmeEmCartaz listaAtual = catalogo.get(posicaoId);

		listaAtual.setId(bodyId.getId());
		listaAtual.setNome(bodyId.getNome());
		listaAtual.setGenero(bodyId.getGenero());

	}

	public void deletar(int posicaoId) {
		catalogo.remove(posicaoId);

	}

}
