package br.ufc.quixada.spa.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name ="id_facebook")
	private Long id_facebook;
	@Column
	private Byte[] foto;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "cidade", nullable = false)
	private String cidade;
	
	@ManyToMany
	@JoinTable(name = "livros_desejados", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
			@JoinColumn(name = "livro_id") })
	private List<Livro> livrosDesejados;

	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Livro> livros;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Livro> getLivros() {
		return livros;
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Livro> getLivrosDesejados() {
		return livrosDesejados;
	}

	public void setLivrosDesejados(List<Livro> livrosDesejados) {
		this.livrosDesejados = livrosDesejados;
	}

	public Long getId_facebook() {
		return id_facebook;
	}

	public void setId_facebook(Long id_facebook) {
		this.id_facebook = id_facebook;
	}
	
}
