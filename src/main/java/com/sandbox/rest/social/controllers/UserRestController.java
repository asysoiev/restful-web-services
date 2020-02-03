package com.sandbox.rest.social.controllers;

import com.sandbox.rest.social.dao.UserDao;
import com.sandbox.rest.social.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public User findUserById(@PathVariable int id) {
        return userDao.findById(id);
    }

}
