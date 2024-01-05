package pe.nico.segovia.services.user;

import pe.nico.segovia.dtos.SignUpRequest;
import pe.nico.segovia.dtos.UserDTO;

public interface IUserService {
    UserDTO createUser(SignUpRequest signUpRequest);
    boolean hasUserWithEmail(String email);
}
