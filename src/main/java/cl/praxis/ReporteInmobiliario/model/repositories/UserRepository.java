package cl.praxis.ReporteInmobiliario.model.repositories;

import cl.praxis.ReporteInmobiliario.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findOneByEmail(String username);
}
