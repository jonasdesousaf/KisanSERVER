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
import br.ufc.quixada.spa.model.Itinerario;
import br.ufc.quixada.spa.service.ItinerarioService;

@Named
@RequestMapping("/itinerarios")
public class ItinerarioController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private ItinerarioService itinerarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Itinerario> findAll() {
		log.debug("Itinerario - GET (all)");
		 List<Itinerario> itinerarios = itinerarioService.find(Itinerario.class);
		 return itinerarios;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Itinerario findById(@PathVariable Long id) {
		log.debug("Itinerario - GET (id)");
		return itinerarioService.find(Itinerario.class, id);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Itinerario itinerario, @PathVariable Long id) {
		log.debug("Itinerario - PUT");
		itinerario.setId(id);
		log.debug("Updating Itinerario: {}", itinerario);
		itinerarioService.update(itinerario);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Itinerario atualizada com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Long id) {
		log.debug("Itinerario - DELETE");
		itinerarioService.delete(new Itinerario(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Itinerario removida com sucesso");
	}
	
}
