package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.exceptions.DuplicateUserException;
import com.sandbox.rest.social.models.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrii Sysoiev
 */
@Profile("memory")
@Component
public class UserDaoMemory implements UserDao {

    private final Map<Integer, User> users = new HashMap<>();
    private int currId;

    public UserDaoMemory() {
        createUser(new User("Adam", LocalDateTime.now()));
        createUser(new User("Eve", LocalDateTime.now()));
        createUser(new User("Jack", LocalDateTime.now()));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User createUser(User user) {
        if (user.getId() == null) {
            user.setId(++currId);
        }
        Integer id = user.getId();
        if (users.containsKey(id)) {
            throw new DuplicateUserException(id);
        }
        users.put(id, user);
        return user;
    }

    @Override
    public User findById(Integer id) {
        return users.get(id);
    }

    @Override
    public User delete(Integer id) {
        return users.remove(id);
    }
}
