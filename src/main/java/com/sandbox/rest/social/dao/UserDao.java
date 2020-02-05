package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.models.User;

import java.util.List;

/**
 * @author Andrii Sysoiev
 */
public interface UserDao {

    List<User> getAll();

    User save(User user);

    User findById(Integer id);

    User delete(Integer id);
}
