package br.ufc.quixada.spa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Itinerario implements Serializable {

    private static final long serialVersionUID = 1L;
	
	public Itinerario() {
		// TODO Auto-generated constructor stub
	}
	
	public Itinerario(Long id) {
		this.setId(id);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "endereco", nullable = false)
	private String endereco;
	
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@Column(name = "dia", nullable = false)
	private String dia;
	
	@Column(name = "mes", nullable = false)
	private String mes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}	
}