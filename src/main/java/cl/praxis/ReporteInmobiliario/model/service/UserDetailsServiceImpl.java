package cl.praxis.ReporteInmobiliario.model.service;

import cl.praxis.ReporteInmobiliario.model.entities.Role;
import cl.praxis.ReporteInmobiliario.model.entities.User;
import cl.praxis.ReporteInmobiliario.model.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository uRepo;

    public UserDetailsServiceImpl(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = uRepo
                .findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));

        return new org.springframework.security.core.userdetails.User(
                ((cl.praxis.ReporteInmobiliario.model.entities.User) user).getEmail(), user.getPassword(), mapperRoles(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> mapperRoles(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getName())).collect(Collectors.toList());
    }


}
