package com.ejercicio.demo.repository;

import com.ejercicio.demo.entities.Phone;
import com.ejercicio.demo.entities.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    final String email = "mail@mail.cl";
    final String name = "somename";

    @BeforeClass
    public static void setUp() {
        System.setProperty("regexEmail", "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z][cl])$");
        System.setProperty("emailPattern", "aaaaaaa@dominio.cl");
        System.setProperty("regexPassword", "^(?\\=.{4,}$)(?\\=(?:.*[A-Z]))(?\\=.*[a-z])(?\\=(?:.*[0-9]){2}).*");
        System.setProperty("inValidPasswordMessage", "La contraseña debe tener una mayúscula, al menos una minuscula y 2 digitos.");
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void integrationTest() {
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void saveUserTest() {
        User user = User.builder()
                .email(email)
                .name(name)
                .password("password")
                .phones(Collections.singletonList(Phone.builder().cityCode("123").countryCode("51").number("123123").build()))
                .build();
        User savedUser = userRepository.save(user);
        Assert.assertNotNull(savedUser);
        Assert.assertNotNull(savedUser.getId());
    }

    @Test
    public void searchUserByEmailTest() {
        Optional<User> userFound = userRepository.findUserByEmail(email);
        Assert.assertTrue(userFound.isPresent());
        Assert.assertEquals(email, userFound.get().getEmail());
    }

    @Test
    public void shouldNotReturnUser() {
        Optional<User> userFound = userRepository.findUserByEmail("someothermail@mail.cl");
        Assert.assertFalse(userFound.isPresent());
    }


}
