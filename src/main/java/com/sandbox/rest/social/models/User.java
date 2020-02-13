package com.sandbox.rest.social.models;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * @author Andrii Sysoiev
 */
@ApiModel(description = "Sample model for experiments")
@Entity
public class User {

    @JsonView(UserView.Short.class)
    @Id
    @GeneratedValue
    private Integer id;
    @JsonView(UserView.Short.class)
    @Size(min = 2, message = "Name must have at least 2 characters")
    @ApiModelProperty(value = "Name must have at least 2 characters")
    private String name;
    @JsonView(UserView.Full.class)
    @Past
    @ApiModelProperty(value = "Must be in the past")
    private LocalDateTime birthDate;

    protected User() {
        //JPA requires default constructor
    }

    public User(@Size(min = 2, message = "Name must have at least 2 characters") String name,
                @Past LocalDateTime birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

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
