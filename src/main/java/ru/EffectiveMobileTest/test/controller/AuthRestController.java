package ru.EffectiveMobileTest.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.EffectiveMobileTest.test.model.User;
import ru.EffectiveMobileTest.test.responses.AuthResponse;
import ru.EffectiveMobileTest.test.security.UserDetailsImpl;
import ru.EffectiveMobileTest.test.service.impl.UserDetailsServiceImpl;
import ru.EffectiveMobileTest.test.service.intrf.JwtTokenService;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;



    @Autowired
    private UserDetailsServiceImpl shopDetailsService;

    @Autowired
    private JwtTokenService jwtTokenService;



    @PostMapping("/authenticate")
    public ResponseEntity signIn(@RequestBody User loginRequest) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));


        UserDetailsImpl shopDetails =
                (UserDetailsImpl) shopDetailsService.loadUserByUsername(loginRequest.getLogin());

        SecurityContextHolder.getContext().setAuthentication(authentication);


        String token = jwtTokenService.generateToken(shopDetails);


        AuthResponse response = new AuthResponse(token, shopDetails);


        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }


}

