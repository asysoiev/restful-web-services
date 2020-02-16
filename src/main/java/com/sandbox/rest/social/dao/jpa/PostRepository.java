package com.sandbox.rest.social.dao.jpa;

import com.sandbox.rest.social.dao.PostDao;
import com.sandbox.rest.social.models.Post;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andrii Sysoiev
 */
@Profile("jpa")
public interface PostRepository extends PostDao, JpaRepository<Post, Integer> {
}
