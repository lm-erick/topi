package topi.test.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import topi.test.models.Evento;
import java.util.List;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Integer> {

    public List<Evento> findByLanguageContaining(String language);
}
