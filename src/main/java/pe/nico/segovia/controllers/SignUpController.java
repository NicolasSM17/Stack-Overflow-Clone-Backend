package pe.nico.segovia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.nico.segovia.dtos.SignUpRequest;
import pe.nico.segovia.dtos.UserDTO;
import pe.nico.segovia.services.user.IUserService;

@RestController
public class SignUpController {

    @Autowired
    private IUserService userService;

    @PostMapping({"/sign-up"})
    public ResponseEntity<?> signUpUser(@RequestBody(required = true) SignUpRequest signUpRequest){
        UserDTO createdUser = userService.createUser(signUpRequest);

        if(createdUser == null){
            return new ResponseEntity<>("User not created, come again later.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
