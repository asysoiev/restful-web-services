package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.models.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Andrii Sysoiev
 */
@Profile("jpa")
@Repository
@Transactional
public class UserDaoJPA implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public User createUser(User user) {
        entityManager.persist(user);

        return user;
    }

    @Override
    public User findById(Integer id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public User delete(Integer id) {
        throw new RuntimeException("Not implemented");
    }
}
