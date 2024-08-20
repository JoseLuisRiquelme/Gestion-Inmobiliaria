package cl.praxis.ReporteInmobiliario.model.service;

import cl.praxis.ReporteInmobiliario.model.entities.User;
import cl.praxis.ReporteInmobiliario.model.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository uRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository uRepository, PasswordEncoder passwordEncoder) {
        this.uRepository = uRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return uRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return uRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(User r) {
        r.setPassword(passwordEncoder.encode(r.getPassword()));
        User report = uRepository.save(r);
        return report!=null;
    }

    @Override
    public boolean update(User r) {
        User report = uRepository.save(r);
        return report!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist=uRepository.existsById(id);
        if(exist){
            uRepository.deleteById(id);
        }
        return exist;
    }
}
