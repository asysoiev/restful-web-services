package com.sandbox.rest.social.dao.inmemory;

import com.sandbox.rest.social.dao.UserDao;
import com.sandbox.rest.social.exceptions.DuplicateUserException;
import com.sandbox.rest.social.models.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Andrii Sysoiev
 */
@Profile("memory")
@Component
public class UserDaoMemory implements UserDao {

    private final Map<Integer, User> users = new HashMap<>();
    private int currId;

    public UserDaoMemory() {
        save(new User("Adam", LocalDate.now()));
        save(new User("Eve", LocalDate.now()));
        save(new User("Jack", LocalDate.now()));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
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
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        users.remove(id);
    }
}
