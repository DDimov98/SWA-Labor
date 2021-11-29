/*========================================================================*
 *                                                                        *
 * This software is governed by the GPL version 2.                        *
 *                                                                        *
 * Copyright: Joerg Friedrich, University of Applied Sciences Esslingen   *
 *                                                                        *
 * $Id:$
 *                                                                        *
 *========================================================================*/
package de.hse.swa.jodel.orm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the POST database table.
 * 
 */
@Entity
@Table(name = "Post")
public class Post  {

    @Id
    @SequenceGenerator(name = "postSeq", sequenceName = "ZSEQ_POST_ID", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "postSeq")
    
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "authorId")
    private Long authorId;

    @Column(name = "pdat")
    private Date postedat;

    public Post() { }
}