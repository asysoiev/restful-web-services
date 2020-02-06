package com.sandbox.rest.social.controllers;

import com.sandbox.rest.social.dao.UserDao;
import com.sandbox.rest.social.exceptions.UserNotFoundException;
import com.sandbox.rest.social.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class UserRestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> findUserById(@PathVariable int id) {
        User user = userDao.findById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }

        //HATEOAS
        //creates a response entity
        EntityModel<User> model = new EntityModel<>(user);
        //creates a link to rest controller method
        //independent from URI
        List<User> allUsers = WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers();
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(allUsers);
        //add the link to the response
        model.add(linkTo.withRel("all-users"));

        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDao.createUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        User user = userDao.delete(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
    }

}
