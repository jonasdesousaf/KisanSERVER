package br.ufc.quixada.spa.control;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.kisan.enumeration.ResponseStatus;
import br.ufc.quixada.kisan.model.ResponseStatusMessage;
import br.ufc.quixada.spa.model.Contato;
import br.ufc.quixada.spa.service.ContatoService;

@Named
@RequestMapping("/contatos")
public class ContatoController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private ContatoService contatoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Contato> findAll() {
		log.debug("Contato - GET (all)");
		 List<Contato> contatos = contatoService.find(Contato.class);
		 return contatos;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Contato findById(@PathVariable Long id) {
		log.debug("Contato - GET (id)");
		return contatoService.find(Contato.class, id);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Contato contato, @PathVariable Long id) {
		log.debug("Contato - PUT");
		contato.setId(id);
		log.debug("Updating Contato: {}", contato);
		contatoService.update(contato);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Contato atualizada com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Long id) {
		log.debug("Contato - DELETE");
		contatoService.delete(new Contato(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Contato removida com sucesso");
	}
	
}
