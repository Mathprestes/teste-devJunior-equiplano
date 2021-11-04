package br.com.springboot.curso_jdev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_apolices")
public class Apolices implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (unique = true)
	private String numero_apolice;
	
	private String inicio_vigencia;
	
	private String fim_vigencia;
	
	private String placa_veiculo;
	
	private String valor_apolice;
	
	//---------------------------------//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero_apolice() {
		return numero_apolice;
	}

	public void setNumero_apolice(String numero_apolice) {
		this.numero_apolice = numero_apolice;
	}

	public String getInicio_vigencia() {
		return inicio_vigencia;
	}

	public void setInicio_vigencia(String inicio_vigencia) {
		this.inicio_vigencia = inicio_vigencia;
	}

	public String getFim_vigencia() {
		return fim_vigencia;
	}

	public void setFim_vigencia(String fim_vigencia) {
		this.fim_vigencia = fim_vigencia;
	}

	public String getPlaca_veiculo() {
		return placa_veiculo;
	}

	public void setPlaca_veiculo(String placa_veiculo) {
		this.placa_veiculo = placa_veiculo;
	}

	public String getValor_apolice() {
		return valor_apolice;
	}

	public void setValor_apolice(String valor_apolice) {
		this.valor_apolice = valor_apolice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
