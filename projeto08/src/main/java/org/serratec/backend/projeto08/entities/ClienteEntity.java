package org.serratec.backend.projeto08.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table (name="cliente")
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cliente_cd_id")
	private Integer idCliente;
	
//	@NotBlank (message="Campo não informado!")
//	@Size(max=50)
	@Column (name="cliente_tx_nome")
	private String nomeCliente;
	
	//@CPF (message="Campo inválido!")
	//@NotBlank(message="Campo não informado!")
	//@Size(max=11)
	@Column(name="cliente_num_cpf", unique = true)
	private Integer cpfCliente;
	
	//@Email(message="Campo inválido!")
//	@NotBlank(message="Campo não informado!")
//	@Size(max=50)
	@Column(name="cliente_tx_email")
	private String emailCliente;
	
	//@NotBlank(message="Campo não informado!")
	//@Size(max=15)
	@Column(name="cliente_num_telefone")
	private Integer telefoneCliente;

	@OneToMany(mappedBy = "cliente")
	private List<CarroEntity> carros;
	
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Integer cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Integer getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(Integer telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public List<CarroEntity> getCarros() {
		return carros;
	}

	public void setCarros(List<CarroEntity> carros) {
		this.carros = carros;
	}


	

	
	
}
