package de.hse.swa.jodel.jaxrs.resources;

import de.hse.swa.jodel.orm.dao.PostDao;
import de.hse.swa.jodel.orm.model.Post;
import io.vertx.core.http.HttpServerRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/Post")
public class PostResource {

    @Inject
    PostDao postDao;

	@Context
    HttpServerRequest request;

	@GET
    @Path("getPosts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPosts(@QueryParam("lat") double lat,@QueryParam("lon") double lon)
    {
        return postDao.getPosts(lat, lon);
    }

    @GET
    @Path("getAllPosts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllPosts()
    {
        return postDao.getAllPosts();
    }

}