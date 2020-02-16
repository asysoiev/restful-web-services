package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.models.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author Andrii Sysoiev
 */
@Profile("jpa")
@Component
public class UserDaoJpaCmdRunner implements CommandLineRunner {

    private static final Logger logger = getLogger(UserDaoJpaCmdRunner.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        User adam = userDao.save(new User("Adam", LocalDate.now().minusYears(10)));
        logger.debug("Created new user: {}", adam);
        User eve = userDao.save(new User("Eve", LocalDate.now().minusYears(30)));
        logger.debug("Created new user: {}", eve);
        User jack = userDao.save(new User("Jack", LocalDate.now().minusYears(20)));
        logger.debug("Created new user: {}", jack);
    }
}
