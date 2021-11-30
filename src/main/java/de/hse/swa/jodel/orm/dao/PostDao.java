/*========================================================================*
 *                                                                        *
 * This software is governed by the GPL version 2.                        *
 *                                                                        *
 * Copyright: Joerg Friedrich, University of Applied Sciences Esslingen   *
 *                                                                        *
 * $Id:$
 *                                                                        *
 *========================================================================*/
package de.hse.swa.jodel.orm.dao;

import de.hse.swa.jodel.orm.model.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class PostDao {

    @Inject
    EntityManager em;


    public List<Post> getAllPosts() {
        //TypedQuery<Post> query = em.createQuery("select u from Post u");
        //List<Post> results = query.getResultList();
        //return results;

        Query q = em.createQuery("select u from Post u ORDER BY postedat DESC");
        List<Post> posts = q.getResultList();
        return posts;
    }


    public List<Post> getPosts(Double lat, Double lon) {
        TypedQuery<Post> query = em.createQuery("SELECT u FROM Post u WHERE u.longitude > '" + (lon - 0.14) + "'  AND " +
                " u.longitude < '" + (lon + 0.14) + "' AND " +
                " u.latitude > '"+ (lat - 0.14) + "' AND " +
                " u.latitude < '" + (lat + 0.14) + "'", Post.class);
        List<Post> results = query.getResultList();
        return results;

    }


    public Post getPost(Long id) {
        return em.find(Post.class, id);
    }

}
