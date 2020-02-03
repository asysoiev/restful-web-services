package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Andrii Sysoiev
 */
@Component
public class UserDaoMemory implements UserDao {

    private final List<User> users = new ArrayList<>();
    private int currId;

    public UserDaoMemory() {
        save(new User().setName("Adam").setBirthDate(LocalDateTime.now()));
        save(new User().setName("Eve").setBirthDate(LocalDateTime.now()));
        save(new User().setName("Jack").setBirthDate(LocalDateTime.now()));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++currId);
        }
        users.add(user);
        return user;
    }

    @Override
    public User findById(Integer id) {
        return users.stream()
                .filter(rec -> Objects.equals(id, rec.getId()))
                .findFirst().orElse(null);
    }
}
