package com.sandbox.rest.social.dao;

import com.sandbox.rest.social.models.Post;

/**
 * @author Andrii Sysoiev
 */
public interface PostDao {

    Post save(Post post);

}