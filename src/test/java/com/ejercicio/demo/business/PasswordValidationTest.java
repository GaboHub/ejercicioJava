package com.ejercicio.demo.business;

import com.ejercicio.demo.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class PasswordValidationTest {

    private PasswordValidation passwordValidation;

    @Before
    public void setUp() {
        passwordValidation = new PasswordValidation();
        ReflectionTestUtils.setField(passwordValidation, "regexPassword", "^(?=.{4,}$)(?=(?:.*[A-Z]))(?=.*[a-z])(?=(?:.*[0-9]){2}).*");
        ReflectionTestUtils.setField(passwordValidation, "inValidPasswordMessage", "La contraseña debe tener una mayúscula, al menos una minuscula y 2 digitos.");
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void shouldNotThrowException() {

        String password = "Test33";
        passwordValidation.validate(password);
    }

    @Test(expected = InvalidFormatException.class)
    public void shouldThrowException() {

        String password = "Not2Digits";
        passwordValidation.validate(password);

    }
}
