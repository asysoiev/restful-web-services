package com.sandbox.rest.social.models;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * @author Andrii Sysoiev
 */
public class User {

    private Integer id;
    private String name;
    private LocalDateTime birthDate;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public User setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("birthDate=" + birthDate)
                .toString();
    }
}
