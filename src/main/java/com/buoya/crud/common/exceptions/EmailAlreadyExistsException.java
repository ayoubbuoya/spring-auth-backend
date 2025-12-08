package com.buoya.crud.common.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Email is already registered: " + email);
    }

}
