package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.kisan.service.GenericService;
import br.ufc.quixada.spa.model.Livro;
import br.ufc.quixada.spa.model.Usuario;

public interface UsuarioService extends GenericService<Usuario>{

	
	public List<Livro> findLivrosById(Long id);
	
	public Usuario findUsuarioByIdFacebook(Long idFacebook);


	
	
}
