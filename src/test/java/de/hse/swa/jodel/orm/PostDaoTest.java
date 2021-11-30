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

@QuarkusTest
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

        private void printPost(Post post) {
            System.out.println("id:" + post.getId());
            System.out.println("text:" + post.getText());
            System.out.println("authorId:" + post.getAuthorId());
            System.out.println("posteDat:" + post.getPostedat());
        }


        @Test
        void addPostTest() {

            User user = createUser("Test");
            Post post = createPost(user, "Hello World");

            List<Post> posts = postDao.getAllPosts();
            assertEquals(posts.size(), 1);
            printPost(post);
        }

}
