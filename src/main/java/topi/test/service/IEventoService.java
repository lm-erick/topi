package topi.test.service;

import topi.test.models.Evento;

import java.util.List;
import java.util.Optional;

public interface IEventoService {
    List<Evento> findAll();

    List<Evento> findByLanguageContaining(String language);

    void save(Evento evento);

    Optional<Evento> findById(int codigo);

}
