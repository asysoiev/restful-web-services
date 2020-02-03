package com.sandbox.rest.helloworld.models;

import java.util.StringJoiner;

/**
 * @author Andrii Sysoiev
 */
public class HelloWorldBean {

    private static final String MSG_TEMPLATE = "Hello World, %s";
    private String message;

    public HelloWorldBean(String name) {
        this.message = String.format(MSG_TEMPLATE, name);
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
