package org.serratec.java2backend.projeto02.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projeto02.dominio.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {  //Classe que contém a lógica de negócio do projeto

	
	List<Todo> lista = new ArrayList<>();
	
	public void adicionar(Todo todo) {
		lista.add(todo);
	}
	
	public List<Todo> listaTodo(){
		return this.lista;
	}
}