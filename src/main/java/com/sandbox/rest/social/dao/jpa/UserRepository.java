package com.sandbox.rest.social.dao.jpa;

import com.sandbox.rest.social.dao.UserDao;
import com.sandbox.rest.social.models.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrii Sysoiev
 */
@Profile("jpa")
public interface UserRepository extends UserDao, JpaRepository<User, Integer> {
}
