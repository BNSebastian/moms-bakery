package family.momsbakery.security.controller;

import family.momsbakery.security.entity.User;
import family.momsbakery.security.jwt.filter.JwtAuthRequest;
import family.momsbakery.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl service;

//    @Autowired
//    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/users/new")
    public String addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PostMapping("/users/authenticate")
    public String getUser(@RequestBody JwtAuthRequest jwtAuthRequest) {
        // store the username and password
        String username = jwtAuthRequest.getUsername();
        String password = jwtAuthRequest.getPassword();
        // authenticate the user
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        // if user is valid generate token
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(username);
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
    }

}
