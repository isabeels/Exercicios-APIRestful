package org.serratec.java2backend.projeto02.controllers;

import java.util.List;

import org.serratec.java2backend.projeto02.dominio.Todo;
import org.serratec.java2backend.projeto02.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController { //Classe responsável por expor as URLs disponíveis da API

	
@Autowired
TodoService todoService;

@GetMapping ("/lista")
public List<Todo> getTodo(){
	return todoService.listaTodo();
}

@PostMapping("/adicionar")
public void adicionar(@RequestBody Todo todo) {
	todoService.adicionar(todo);
}

}
