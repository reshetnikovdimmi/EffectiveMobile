package ru.EffectiveMobileTest.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.EffectiveMobileTest.test.model.User;
import ru.EffectiveMobileTest.test.repository.UserRepository;

@RestController

public class TaskController {
@Autowired
private UserRepository userRepository;


    @GetMapping("/update")
    public Iterable<User> update() {

        return userRepository.findAll();
    }
}
