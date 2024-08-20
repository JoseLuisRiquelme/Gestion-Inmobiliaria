package cl.praxis.ReporteInmobiliario.model.repositories;

import cl.praxis.ReporteInmobiliario.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
