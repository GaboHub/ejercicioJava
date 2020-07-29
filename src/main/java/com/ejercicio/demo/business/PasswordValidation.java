package com.ejercicio.demo.business;

import com.ejercicio.demo.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidation {


    @Value("${regexPassword}")
    private String regexPassword;

    @Value("${inValidPasswordMessage}")
    private String inValidPasswordMessage;

    public void validate(String password) {

        boolean isValid = password.matches(regexPassword);

        if(!isValid) {
            throw new InvalidFormatException(inValidPasswordMessage);
        }

    }
}
