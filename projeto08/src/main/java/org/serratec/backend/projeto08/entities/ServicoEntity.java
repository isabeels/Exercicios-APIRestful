package org.serratec.backend.projeto08.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="servico")
public class ServicoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="servico_cd_id")
	private Integer idServico;
	
//	@NotBlank(message="Campo não informado!")
	@Column (name="servico_nu_valor")
	private Double valorServico;
	
//	@NotBlank(message="Campo não informado!")
	@Column (name="servico_tx_tipo")
	private String tipoServico;
	
//	@NotBlank(message="Campo não informado!")
	@Column (name="servico_dt_data")
	private LocalDate dataServico;

	@ManyToOne
	@JoinColumn(name="carro_id", referencedColumnName = "carro_cd_id")
	@JsonIgnore
	private CarroEntity carro;
	

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

	public CarroEntity getCarro() {
		return carro;
	}

	public void setCarro(CarroEntity carro) {
		this.carro = carro;
	}
	
	


}
