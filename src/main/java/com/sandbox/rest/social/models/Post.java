package com.sandbox.rest.social.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.StringJoiner;

import static javax.persistence.FetchType.LAZY;

/**
 * @author Andrii Sysoiev
 */
@Entity
public class Post {

    @Id
    @SequenceGenerator(name = "post_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "post_id_seq")
    private Integer id;
    private String description;

    @ManyToOne(fetch = LAZY)
    private User user;

    public Integer getId() {
        return id;
    }

    public Post setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Post setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("description='" + description + "'")
                .toString();
    }
}
