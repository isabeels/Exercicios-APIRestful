package org.serratec.backend.projeto08.dto;

public class CarroDTO {

	private Integer idCarro;
	private String modeloCarro;
	private String marcaCarro;
	private Integer anoCarro;
	private Integer idCliente;
	
	
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
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
