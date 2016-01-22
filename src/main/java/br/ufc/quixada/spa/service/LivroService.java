package br.ufc.quixada.spa.service;


import java.util.List;

import br.ufc.quixada.kisan.service.GenericService;
import br.ufc.quixada.spa.model.Livro;

public interface LivroService extends GenericService<Livro> {

	
	public String insereLivroEmWishList(Long idLivro, Long idUsuario);

	public String removeLivroDaWishList(Long idLivro, Long  idUsuario);
	
	 public List<Livro> findLivroUsuarioEmWishlist( Long idUsuario);
	
	 public void insereLivro(Livro livro, Long idUsuario);
}
