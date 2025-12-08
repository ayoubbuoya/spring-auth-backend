package com.buoya.crud.common.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(String username) {
        super("Username is already registered: " + username);
    }

}
