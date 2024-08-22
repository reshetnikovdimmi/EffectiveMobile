package ru.effectivemobile.test.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.effectivemobile.test.dtos.LoginUserDto;
import ru.effectivemobile.test.dtos.RegisterUserDto;
import ru.effectivemobile.test.model.LoginResponse;
import ru.effectivemobile.test.model.User;
import ru.effectivemobile.test.service.AuthenticationService;
import ru.effectivemobile.test.service.JwtService;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {

        System.out.println(loginUserDto.getEmail());

        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        System.out.println(loginUserDto.getPassword());

        String jwtToken = jwtService.generateToken((UserDetails) authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
