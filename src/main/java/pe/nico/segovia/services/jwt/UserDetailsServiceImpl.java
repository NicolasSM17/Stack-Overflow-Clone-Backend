package pe.nico.segovia.services.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.nico.segovia.entities.UserEntity;
import pe.nico.segovia.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findFirstByEmail(email);

        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("User not Found");
        }

        return new User(userOptional.get().getEmail(), userOptional.get().getPassword(),
                        new ArrayList<>());
    }
}
