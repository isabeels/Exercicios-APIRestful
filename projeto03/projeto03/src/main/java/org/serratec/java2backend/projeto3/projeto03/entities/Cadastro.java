package org.serratec.java2backend.projeto3.projeto03.entities;

public class Cadastro {

	private Integer id;
	private String nome;
	private String escolaridade;
	
	//Construtores
	
	public Cadastro(Integer id, String nome, String escolaridade) {
		super();
		this.id = id;
		this.nome = nome;
		this.escolaridade = escolaridade;
	}
	
	public Cadastro() {
		
	}

	
	//Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	
	
	
}
