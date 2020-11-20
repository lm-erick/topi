package topi.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import topi.test.models.Evento;
import topi.test.service.EventoService;
import topi.test.service.IEventoService;

import java.util.List;

@Controller
public class EventoController {
    @Autowired
    private IEventoService eventoService;

    @RequestMapping("/buscar/{language}")
    @ResponseBody
    public List<Evento>   findEventos(@PathVariable("language") String language) {
        return eventoService.findByLanguageContaining(language);
    }

    @RequestMapping("/salvar/{codigo}")
    @ResponseBody
    public void save(Evento evento, @PathVariable("codigo") int codigo){

        Evento event = new Evento();
        event.setAvatar(evento.getAvatar());
        event.setCodigo(codigo);
        event.setName(evento.getName());
        event.setForks(evento.getForks());
        event.setStars(evento.getStars());
        event.setLanguage(evento.getLanguage());
        event.setUrlRepository(evento.getUrlRepository());
        eventoService.save(event);
    }
}
