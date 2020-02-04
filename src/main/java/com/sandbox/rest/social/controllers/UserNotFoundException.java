package com.sandbox.rest.social.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Andrii Sysoiev
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private static final String USER_NOT_FOUND_MSG = "User: \"%s\" not found.";

    public UserNotFoundException(int userId) {
        super(String.format(USER_NOT_FOUND_MSG, userId));
    }
}
