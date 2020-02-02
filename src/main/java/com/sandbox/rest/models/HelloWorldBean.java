package com.sandbox.rest.models;

import java.util.StringJoiner;

/**
 * @author Andrii Sysoiev
 */
public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", HelloWorldBean.class.getSimpleName() + "[", "]")
                .add("message='" + message + "'")
                .toString();
    }
}
