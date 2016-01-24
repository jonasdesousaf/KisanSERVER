package br.ufc.quixada.spa.service.impl;

import java.util.List;

import javax.inject.Named;

import br.ufc.quixada.kisan.enumeration.QueryType;
import br.ufc.quixada.kisan.service.impl.GenericServiceImpl;
import br.ufc.quixada.kisan.util.SimpleMap;
import br.ufc.quixada.spa.model.Livro;
import br.ufc.quixada.spa.model.Usuario;

import br.ufc.quixada.spa.service.UsuarioService;

@Named
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService{

	@Override
	public List<Livro> findLivrosById(Long id) {
		Usuario  usuario = find(Usuario.class, id);
		return usuario.getLivros();
	}

	@Override
	public Usuario findUsuarioByIdFacebook(Long idFacebook) {
		Object obj = findFirst(QueryType.NATIVE,
				"select * from usuario where id_facebook = :idFacebook",
				new SimpleMap<String, Object>("idFacebook", idFacebook));
		return (Usuario) obj;
	}
}
