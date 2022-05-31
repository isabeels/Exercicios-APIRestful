package org.serratec.backendprojeto05.projeto05.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_cd_id")
	private Integer idCliente;
	
	@Column(name="cliente_tx_nome")
	private String nome;
	
	//@Size(max = 11)
	@Column(name="cliente_tx_cpf",unique = true)
	private String cpf;
	
	@Column(name="cliente_tx_numero_telefone")
	private String numeroTelefone;
	
	@Column(name="cliente_tx_email")
	private String email;
	
	@Column(name="cliente_dt_nascimento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "cliente")
	private List<Cartao> listaCartao;
	
	//Se fosse OneToOne
//	@OneToOne(mappedBy = "cliente")
//	private Cartao cartao;
	
	public Cliente() {}
	
	
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


	public List<Cartao> getListaCartao() {
		return listaCartao;
	}


	public void setListaCartao(List<Cartao> listaCartao) {
		this.listaCartao = listaCartao;
	}
	
	

}
