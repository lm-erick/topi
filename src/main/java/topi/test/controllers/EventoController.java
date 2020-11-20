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

    @RequestMapping("/buscar")
    @ResponseBody
    public List<Evento>   findEventos() {
        return eventoService.findAll();
    }

    @RequestMapping("/salvar/{codigo}")
    @ResponseBody
    public void save(Evento evento, @PathVariable("codigo") int codigo){

        String avatar = evento.getAvatar();
        String name = evento.getName();
        int stars = evento.getStars();
        int forks = evento.getForks();

        Evento event = new Evento();
        event.setAvatar(avatar);
        event.setCodigo(codigo);
        event.setName(name);
        event.setForks(forks);
        event.setStars(stars);

        eventoService.save(event);
    }
}
