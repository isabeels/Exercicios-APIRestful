package org.serratec.backendprojeto05.projeto05.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_cd_id")
	private Integer idCliente;
	
	@Column(name="cliente_tx_nome")
	private String nome;
	
	@Column(name="cliente_tx_cpf")
	private String cpf;
	
	@Column(name="cliente_tx_numero_telefone")
	private String numeroTelefone;
	
	@Column(name="cliente_tx_email")
	private String email;
	
	@Column(name="cliente_dt_nascimento")
	private Date dataNascimento;
	
	public Cliente() {
		
	}
	

	public Cliente(Integer idCliente, String nome, String cpf, String numeroTelefone, String email, Date dataNascimento) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}


	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
