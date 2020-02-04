package com.sandbox.rest.social.controllers;

/**
 * @author Andrii Sysoiev
 */
public class UserNotFoundException extends RuntimeException {
    private static final String USER_NOT_FOUND_MSG = "User: \"%s\" not found.";

    public UserNotFoundException(int userId) {
        super(String.format(USER_NOT_FOUND_MSG, userId));
    }
}
