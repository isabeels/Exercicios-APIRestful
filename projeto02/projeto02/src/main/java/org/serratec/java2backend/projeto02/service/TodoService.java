package org.serratec.java2backend.projeto02.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projeto02.dominio.Todo;
import org.serratec.java2backend.projeto02.exception.TodoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TodoService { // Classe que contém a lógica de negócio do projeto

	@Value("${url.serratec}")
	private String urlSerratec;
	
	List<Todo> lista = new ArrayList<>();

	public void adicionar(Todo todo) {
		lista.add(todo);
	}

	public List<Todo> listaTodo() {
		return this.lista;
	}

	public void atualizar(Integer posicaoLista, Todo todoDaApi) {
		Todo todoDaListaSalva = new Todo();
		todoDaListaSalva = lista.get(posicaoLista);

		todoDaListaSalva.setId(todoDaApi.getId());
		todoDaListaSalva.setDescricao(todoDaApi.getDescricao());
		todoDaListaSalva.setTitulo(todoDaApi.getTitulo());

	}

	public Todo buscarPorId(Integer idTodo) throws TodoException {
		Todo todoNoBanco = new Todo();
		for (Todo todo : lista) {
			if (todo.getId().equals(idTodo)) {
				todoNoBanco = todo;
			}
			if(todoNoBanco.getId()== null) {
			throw new TodoException(idTodo);
		}
	}
		return todoNoBanco;
	}
	
	public void deletar(int posicaoLista) {
		lista.remove(posicaoLista);
	}
}
