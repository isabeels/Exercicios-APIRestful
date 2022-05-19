package org.serratec.java2backend.projeto02.dominio;

public class Todo {

//Atributos 
	
private Integer id;
private String titulo;
private String descricao;

//Construtores

public Todo(Integer id, String titulo, String descricao) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.descricao = descricao;
}

public Todo() {
	
}

//Getters e Setters

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}

}
