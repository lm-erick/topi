package topi.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import topi.test.models.Evento;
import topi.test.repository.EventoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements IEventoService {
    @Autowired
    private EventoRepository repository;

    @Override
    public List<Evento> findAll() {
        return (List<Evento>) repository.findAll();
    }

    @Override
    public void save(Evento evento) {
        repository.save(evento);
    }

    @Override
    public Optional<Evento> findById(int codigo) {
        return repository.findById(codigo);
    }


}
