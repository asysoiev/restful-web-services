package com.sandbox.rest.social.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.sandbox.rest.social.dao.UserDao;
import com.sandbox.rest.social.exceptions.UserNotFoundException;
import com.sandbox.rest.social.models.Post;
import com.sandbox.rest.social.models.User;
import com.sandbox.rest.social.models.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
public class SocialMediaRestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    @JsonView(UserView.Short.class)
    public List<User> getAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    @JsonView(UserView.Full.class)
    public Resource<User> findUserById(@PathVariable int id) {
        User user = userDao.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        //HATEOAS sb 2.2.4
//        EntityModel<User> model = new EntityModel<>(user);
//        List<User> allUsers = WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers();
//        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(allUsers);
//        model.add(linkTo.withRel("all-users"));

        //HATEOAS sb 2.1.3
        Resource<User> resource = new Resource<>(user);
        List<User> allUsers = ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers();
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(allUsers);
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDao.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userDao.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {
        User user = userDao.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return user.getPosts();
    }
}
