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
import br.ufc.quixada.spa.model.Endereco;
import br.ufc.quixada.spa.service.EnderecoService;

@Named
@RequestMapping("/endereco")
public class EnderecoController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private EnderecoService enderecoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Endereco> findAll() {
		log.debug("Endereco - GET (all)");
		 List<Endereco> enderecos = enderecoService.find(Endereco.class);
		 return enderecos;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Endereco findById(@PathVariable Long id) {
		log.debug("Endereco - GET (id)");
		return enderecoService.find(Endereco.class, id);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Endereco endereco, @PathVariable Long id) {
		log.debug("Endereco - PUT");
		endereco.setId(id);
		log.debug("Updating Endereco: {}", endereco);
		enderecoService.update(endereco);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Endereco atualizada com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Long id) {
		log.debug("Endereco - DELETE");
		enderecoService.delete(new Endereco(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Endereco removida com sucesso");
	}
	
}
