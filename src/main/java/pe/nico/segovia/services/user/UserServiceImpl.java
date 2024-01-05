package pe.nico.segovia.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.nico.segovia.dtos.SignUpRequest;
import pe.nico.segovia.dtos.UserDTO;
import pe.nico.segovia.entities.UserEntity;
import pe.nico.segovia.repositories.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDTO createUser(SignUpRequest signUpRequest) {
        UserEntity user = new UserEntity();
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        UserEntity createdUser = userRepository.save(user);

        UserDTO createdUserDTO = new UserDTO();
        createdUserDTO.setId(createdUser.getId());

        return createdUserDTO;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
