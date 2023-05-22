package family.momsbakery.security2.controller;

import family.momsbakery.security2.entity.Role;
import family.momsbakery.security2.entity.User;;
import family.momsbakery.security2.jwt.dto.JwtAuthRequest;
import family.momsbakery.security2.repository.RoleRepository;
import family.momsbakery.security2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserController {

    private AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //private JWTGenerator jwtGenerator;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/users/new")
    public ResponseEntity<String> addUser(@RequestBody JwtAuthRequest jwtAuthRequest) {
        if (userRepository.existsByUsername(jwtAuthRequest.getUsername())) {
            return new ResponseEntity<>("Username " + jwtAuthRequest.getUsername() + " taken!", HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            user.setUsername(jwtAuthRequest.getUsername());
            user.setPassword(passwordEncoder.encode(jwtAuthRequest.getPassword()));
            userRepository.save(user);

            return new ResponseEntity<>("Username " + jwtAuthRequest.getUsername() + " registered successfully!", HttpStatus.OK);
        }
    }


}
