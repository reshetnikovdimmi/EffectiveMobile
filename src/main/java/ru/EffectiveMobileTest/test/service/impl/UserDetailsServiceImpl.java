package ru.EffectiveMobileTest.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.EffectiveMobileTest.test.model.User;
import ru.EffectiveMobileTest.test.repository.UserRepository;
import ru.EffectiveMobileTest.test.security.ShopDetailsImpl;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByLogin(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new ShopDetailsImpl(userOptional.get());
    }
}
