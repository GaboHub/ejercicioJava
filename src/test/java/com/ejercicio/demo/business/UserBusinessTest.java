package com.ejercicio.demo.business;

import com.ejercicio.demo.entities.Phone;
import com.ejercicio.demo.entities.User;
import com.ejercicio.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserBusinessTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailValidation emailValidation;

    @Mock
    private PasswordValidation passwordValidation;

    @Captor
    private ArgumentCaptor<User> argCaptor;

    private UserBusiness userBusiness;

    @Before
    public void setUp() {

        userBusiness = new UserBusiness();
        ReflectionTestUtils.setField(userBusiness, "userRepository", userRepository);
        ReflectionTestUtils.setField(userBusiness, "emailValidation", emailValidation);
        ReflectionTestUtils.setField(userBusiness, "passwordValidation", passwordValidation);

    }

    @Test
    public void givenUserShouldReturnFullDetailedUser() {

        final String email = "some@mail.cl";
        final String password = "Somepassword12";

        User user = User.builder()
                .email(email)
                .name("someName")
                .password(password)
                .phones(Collections.singletonList(Phone.builder().cityCode("123").countryCode("51").number("123123").build()))
                .build();

        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.empty());

        userBusiness.saveNewUser(user);

        Mockito.verify(emailValidation).validate(email);
        Mockito.verify(passwordValidation).validate(password);
        Mockito.verify(userRepository).save(argCaptor.capture());

        User savedUser = argCaptor.getValue();
        Assert.assertNotNull(savedUser);
        Assert.assertNotNull(savedUser.getId());
        Assert.assertNotNull(savedUser.getCreated());
        Assert.assertEquals(savedUser.getCreated(), savedUser.getLastLogin());
        Assert.assertTrue(savedUser.isActive());
        Assert.assertNotNull(savedUser.getToken());
    }


}
