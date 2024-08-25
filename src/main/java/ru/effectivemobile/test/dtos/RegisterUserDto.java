package ru.effectivemobile.test.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    @Column(unique = true)
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @Size(min = 2, max = 20, message = "Login should be from 2 to 20 chars")
    private String password;
    @Column(unique = true)
    @Size(min = 2, max = 20, message = "Login should be from 2 to 20 chars")
    private String login;
}