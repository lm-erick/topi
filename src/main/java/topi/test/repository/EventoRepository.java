package topi.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import topi.test.models.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
