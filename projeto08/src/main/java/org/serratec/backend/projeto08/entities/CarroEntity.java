package org.serratec.backend.projeto08.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name= "carro")
public class CarroEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="carro_cd_id")
	private Integer idCarro;

	
//	@NotBlank(message="Campo não informado!")
//	@Size(max=20)
	@Column (name="carro_tx_modelo")
	private String modeloCarro;
	
//	@NotBlank(message="Campo não informado!")
//	@Size(max=20)
	@Column(name="carro_tx_marca")
	private String marcaCarro;
	
//	@NotBlank(message="Campo não informado!")
	//@Max(value = 2022, message = "Ano do carro não pode ser maior que 2022.")
	@Column(name="carro_nu_ano")
	private Integer anoCarro;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName = "cliente_cd_id")
	@JsonIgnore
	private ClienteEntity cliente;
	
	@OneToMany(mappedBy = "carro")
	private List<ServicoEntity> servicos;

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getMarcaCarro() {
		return marcaCarro;
	}

	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}

	public Integer getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(Integer anoCarro) {
		this.anoCarro = anoCarro;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public List<ServicoEntity> getServicos() {
		return servicos;
	}

	public void setServicos(List<ServicoEntity> servicos) {
		this.servicos = servicos;
	}

	

	
	
	
	
	

}
