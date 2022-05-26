package org.serratec.backend.projeto07.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "livraria")
public class Livraria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "livro_id")
	private Integer idLivro;
	
	@NotNull
	@Size(min = 5, max = 30)
	@Column (name = "livro_tx_titulo")
	private String tituloLivro;
	
	@NotNull
	@Size(min = 3, max = 20)
	@Column (name = "livro_tx_tipo")
	private String tipoLivro;
	
	@NotNull
	@Size(min = 10, max = 40)
	@Column (name = "livro_tx_autor")
	private String autorLivro;
	
	@Past
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column (name = "livro_data_publicacao")
	private LocalDate dataPublicacao;
	
	//Construtores
	
	public Livraria() {}

	public Livraria(Integer idLivro, String tituloLivro, String tipoLivro, String autorLivro,
			LocalDate dataPublicacao) {
		super();
		this.idLivro = idLivro;
		this.tituloLivro = tituloLivro;
		this.tipoLivro = tipoLivro;
		this.autorLivro = autorLivro;
		this.dataPublicacao = dataPublicacao;
	}
	
	//Getters e Setters

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
}
