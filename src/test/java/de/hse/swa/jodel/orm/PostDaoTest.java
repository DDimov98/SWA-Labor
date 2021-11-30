package de.hse.swa.jodel.orm;

//imports//

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import de.hse.swa.jodel.orm.model.Post;
import de.hse.swa.jodel.orm.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.hse.swa.jodel.orm.dao.UserDao;
import de.hse.swa.jodel.orm.dao.PostDao;
import io.quarkus.test.junit.QuarkusTest;
public class PostDaoTest {

        @Inject
        UserDao userDao;

        @Inject
        PostDao postDao;

        private User createUser(String name) {
            User user = new User();
            user.setUsername(name);
            user.setPassword("password");
            userDao.save(user);
            return user;
        }

        private Post createPost(User user, String text) {
            Post post = new Post();
            post.setText(text);
            post.setAuthorId(user.getId());
            post.setPostedat(new Date());
            postDao.save(post);
            return post;
        }

}
