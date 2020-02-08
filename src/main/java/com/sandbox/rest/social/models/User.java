package com.sandbox.rest.social.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * @author Andrii Sysoiev
 */
@ApiModel(description = "Sample model for experiments")
public class User {

    private Integer id;
    @Size(min = 2, message = "Name must have at least 2 characters")
    @ApiModelProperty(value = "Name must have at least 2 characters")
    private String name;
    @Past
    @ApiModelProperty(value = "Must be in the past")
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
