package ru.EffectiveMobileTest.test.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.EffectiveMobileTest.test.model.User;
import ru.EffectiveMobileTest.test.repository.UserRepository;
import ru.EffectiveMobileTest.test.service.AbstractCRUDService;
import ru.EffectiveMobileTest.test.service.interf.UserService;

@Service
@Validated
public class UserServiceImpl extends AbstractCRUDService<User, Long> implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CrudRepository getRepository() {
        return userRepository;
    }
    @Override
    public void create(@Validated User user) throws UsernameNotFoundException {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        getRepository().save(user);


    }
}
