package com.ejercicio.demo.controller;

import com.ejercicio.demo.business.UserBusiness;
import com.ejercicio.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @RequestMapping(value = "/")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Running...");
    }

    @GetMapping(value = "/user")
    public ResponseEntity<User> getUser(@RequestParam String username) {
        return userBusiness.findByFirstName(username).stream().findFirst()
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Optional<User>> saveUser(@RequestBody User user) {
        Optional<User> createdUser = Optional.of(userBusiness.saveNewUser(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

//    @PostMapping(value = "/login")
//    public ResponseEntity<User> login(@RequestBody Login login) {
//        Optional<User> authenticatedUser = Optional.of(userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword()));
//        return ResponseEntity.of(authenticatedUser);
//    }
}
