package com.sandbox.rest.social.exceptions;

/**
 * @author Andrii Sysoiev
 */
public class DuplicateUserException extends RuntimeException {

    private static final String MSG_TEMPLATE = "User id: %d is already used!";

    public DuplicateUserException(Integer id) {
        super(String.format(MSG_TEMPLATE, id));
    }
}
