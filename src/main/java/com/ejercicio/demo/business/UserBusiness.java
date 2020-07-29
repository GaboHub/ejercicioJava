package com.ejercicio.demo.business;

import com.ejercicio.demo.entities.User;
import com.ejercicio.demo.exceptions.UserRegisteredException;
import com.ejercicio.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserBusiness {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailValidation emailValidation;

    @Autowired
    private PasswordValidation passwordValidation;

    public User saveNewUser(User user) throws UserRegisteredException {

        userRepository.findUserByEmail(user.getEmail()).ifPresent(a -> { throw new UserRegisteredException("El correo ya registrado: " + a.getEmail()); } );


        emailValidation.validate(user.getEmail());
        passwordValidation.validate(user.getPassword());

        User newUser = User.builder()
                .id(UUID.randomUUID())
                .created(LocalDateTime.now())
                .lastLogin(LocalDateTime.now())
                .token(UUID.randomUUID().toString())
                .active(true)
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .phones(user.getPhones())
                .build();
        return userRepository.save(newUser);

    }
}
