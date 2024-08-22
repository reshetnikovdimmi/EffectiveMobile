package ru.EffectiveMobileTest.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String login;
    private String password;
    private String role;
    private String email;
}
