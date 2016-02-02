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
import br.ufc.quixada.spa.model.Evento;
import br.ufc.quixada.spa.service.EventoService;

@Named
@RequestMapping("/eventos")
public class EventoController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private EventoService eventoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Evento> findAll() {
		log.debug("Evento - GET (all)");
		 List<Evento> eventos = eventoService.find(Evento.class);
		 return eventos;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Evento findById(@PathVariable Long id) {
		log.debug("Evento - GET (id)");
		return eventoService.find(Evento.class, id);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Evento evento, @PathVariable Long id) {
		log.debug("Evento - PUT");
		evento.setId(id);
		log.debug("Updating Evento: {}", evento);
		eventoService.update(evento);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Evento atualizada com sucesso");
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Long id) {
		log.debug("Evento - DELETE");
		eventoService.delete(new Evento(id));
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Evento removida com sucesso");
	}
	
}
