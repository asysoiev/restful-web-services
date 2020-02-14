package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.models.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
public interface UserDao {

    List<User> findAll();

    User save(User user);

    Optional<User> findById(Integer id);

    void deleteById(Integer id);
}
