package org.serratec.backend.projeto08.dto;




public class ClienteDTO {

private Integer idCliente;
	
	private String nomeCliente;
	private Integer cpfCliente;
	private String emailCliente;
	private Integer telefoneCliente;
	
	
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

}
