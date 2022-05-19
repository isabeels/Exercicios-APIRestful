package org.serratec.backend.projeto04.entities;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity

public class FilmeEmCartaz {

	private Integer id;
	private String nome;
	private String genero;

	public FilmeEmCartaz() {}
	
	public FilmeEmCartaz(Integer id, String nome, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
	}

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
