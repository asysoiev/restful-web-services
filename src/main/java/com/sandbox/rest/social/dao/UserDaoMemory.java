package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andrii Sysoiev
 */
@Component
public class UserDaoMemory implements UserDao {

    private final Map<Integer, User> users = new HashMap<>();
    private int currId;

    public UserDaoMemory() {
        save(new User().setName("Adam").setBirthDate(LocalDateTime.now()));
        save(new User().setName("Eve").setBirthDate(LocalDateTime.now()));
        save(new User().setName("Jack").setBirthDate(LocalDateTime.now()));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++currId);
        }
        users.put(user.getId(), user);
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
