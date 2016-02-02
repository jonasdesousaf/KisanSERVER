package br.ufc.quixada.spa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Contato(){
		
	}
	
	public Contato(Long id) {
		this.setId(id);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dep", nullable = false)
	private String dep;
	
	@Column(name = "resp", nullable = false)
	private String resp;

	@Column(name = "ass", nullable = false)
	private String ass;
	
	@Column(name = "email_resp", nullable = false)
	private String email_resp;
	
	@Column(name = "email_ass", nullable = false)
	private String email_ass;
	
	@Column(name = "telefone_resp", nullable = false)
	private String telefone_resp;
	
	@Column(name = "telefone_ass", nullable = false)
	private String telefone_ass;
	
	@Column(name = "igreja", nullable = false)
	private String igreja;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public String getAss() {
		return ass;
	}

	public void setAss(String ass) {
		this.ass = ass;
	}

	public String getEmail_resp() {
		return email_resp;
	}

	public void setEmail_resp(String email_resp) {
		this.email_resp = email_resp;
	}

	public String getEmail_ass() {
		return email_ass;
	}

	public void setEmail_ass(String email_ass) {
		this.email_ass = email_ass;
	}

	public String getTelefone_resp() {
		return telefone_resp;
	}

	public void setTelefone_resp(String telefone_resp) {
		this.telefone_resp = telefone_resp;
	}

	public String getTelefone_ass() {
		return telefone_ass;
	}

	public void setTelefone_ass(String telefone_ass) {
		this.telefone_ass = telefone_ass;
	}

	public String getIgreja() {
		return igreja;
	}

	public void setIgreja(String igreja) {
		this.igreja = igreja;
	}

	
	
}
