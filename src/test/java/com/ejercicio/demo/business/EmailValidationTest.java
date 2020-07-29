package com.ejercicio.demo.business;

import com.ejercicio.demo.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class EmailValidationTest {

    private EmailValidation emailValidation;

    @Before
    public void setUp() {
        emailValidation = new EmailValidation();
        ReflectionTestUtils.setField(emailValidation, "regexEmail", "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z][cl])$");
        ReflectionTestUtils.setField(emailValidation, "emailPattern", "aaaaaaa@dominio.cl");
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void shouldReturnTrueWhenValidMail() {

        String email = "test@test.cl";
        emailValidation.validate(email);
    }

    @Test(expected = InvalidFormatException.class)
    public void shouldReturnFalseWhenInValidMail() {

        String email = "testtest.cl";
        emailValidation.validate(email);

    }
}
