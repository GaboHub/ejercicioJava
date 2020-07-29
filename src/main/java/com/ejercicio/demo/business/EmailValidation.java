package com.ejercicio.demo.business;

import com.ejercicio.demo.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailValidation {


    @Value("${regexEmail}")
    private String regexEmail;

    @Value("${emailPattern}")
    private String emailPattern;

    public void validate(String email) {

        boolean isValid = email.matches(regexEmail);

        if(!isValid) {
            throw new InvalidFormatException("Email no cumple con el formato: " + emailPattern);
        }

    }
}
