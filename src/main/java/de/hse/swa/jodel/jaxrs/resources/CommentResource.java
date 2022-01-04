package de.hse.swa.jodel.jaxrs.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Context;

import de.hse.swa.jodel.orm.dao.CommentDao;
import de.hse.swa.jodel.orm.dao.PostDao;
import de.hse.swa.jodel.orm.dao.UserDao;
import de.hse.swa.jodel.orm.model.Comment;
import de.hse.swa.jodel.orm.model.Post;
import de.hse.swa.jodel.orm.model.User;

import io.vertx.core.http.HttpServerRequest;


@Path("/Comments")
public class CommentResource {

    @Inject
    CommentDao commentDao;
    @Inject
    UserDao userDao;
    @Inject
    PostDao postDao;


    @Context
    HttpServerRequest request;

    @GET
    @Path("getComments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getComments(@QueryParam("postId") Long postId){
        return commentDao.getComments(postId);
    }


    @POST
    @Path("addComment")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(@QueryParam("text") String text, @QueryParam("lon") double longitude, @QueryParam("lat") double latitude, @QueryParam("authorId") Long authorId, @QueryParam("postId") Long postId)
    {
/*
        User user2 = new User();
        user2.setPassword("12345");
        user2.setUsername("test");
        userDao.save(user2);

        Post post = new Post();
        post.setText("postpost");
        post.setLongitude(10);
        post.setLatitude(10);

        Date date = new Date();
        post.setPostedat(date);

        post.setAuthorId(user);
*/
        Comment comment = new Comment(text, longitude, latitude, authorId, postId);
        // comment.setPostedat();
        //comment.setPostId(postDao.getPost(id));

        return commentDao.save(comment);
    }
}