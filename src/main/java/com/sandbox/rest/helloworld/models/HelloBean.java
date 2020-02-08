package com.sandbox.rest.helloworld.models;

import java.util.StringJoiner;

/**
 * @author Andrii Sysoiev
 */
public class HelloBean {

    private String message;

    public HelloBean(String message) {
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
        return new StringJoiner(", ", HelloBean.class.getSimpleName() + "[", "]")
                .add("message='" + message + "'")
                .toString();
    }
}
