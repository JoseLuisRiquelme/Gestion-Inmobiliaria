package cl.praxis.ReporteInmobiliario.model.service;

import cl.praxis.ReporteInmobiliario.model.entities.Report;
import cl.praxis.ReporteInmobiliario.model.entities.Role;
import cl.praxis.ReporteInmobiliario.model.repositories.ReportRepository;
import cl.praxis.ReporteInmobiliario.model.repositories.RoleRepository;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roRepository;

    public RoleServiceImpl(RoleRepository roRepository) {
        this.roRepository = roRepository;
    }

    @Override
    public List<Role> findAll() {
        return roRepository.findAll();
    }

    @Override
    public Role findOne(int id) {
        return roRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Role r) {
        Role role = roRepository.save(r);
        return role!=null;
    }

    @Override
    public boolean update(Role r) {
        Role role = roRepository.save(r);
        return role!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist=roRepository.existsById(id);
        if(exist){
            roRepository.deleteById(id);
        }
        return exist;
    }
}
