package org.serratec.backend.projeto08.dto;

import java.time.LocalDate;




public class ServicoDTO {

	private Integer idServico;
	private Double valorServico;
	private String tipoServico;
	private LocalDate dataServico;
	private Integer idCarro;
	
	
	public Integer getIdServico() {
		return idServico;
	}
	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}
	public Double getValorServico() {
		return valorServico;
	}
	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	public LocalDate getDataServico() {
		return dataServico;
	}
	public void setDataServico(LocalDate dataServico) {
		this.dataServico = dataServico;
	}
	public Integer getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

}
