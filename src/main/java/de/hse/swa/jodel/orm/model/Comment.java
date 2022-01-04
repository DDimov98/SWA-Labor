package de.hse.swa.jodel.orm.model;

import java.util.Date;
import javax.json.bind.annotation.JsonbAnnotation;
import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * The persistent class for the `COMMENT` database table.
 * 
 */
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @SequenceGenerator(name = "commentSeq", sequenceName = "ZSEQ_COMMENT_ID", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "commentSeq")
    
    @Column(name = "id")
    private Long id;

    @Column(name = "authorId")
    private Long authorId;

    @Column(name = "text")
    private String text;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "postedat")
    private Date postedat;

    @Column(name = "postId")
    public long postId;

    public Comment() {
    }

    public Comment(String text, double longitude, double latitude, Long userId, Long postId ) {
        this.text = text;
        this.longitude = longitude;
        this.latitude = latitude;
        this.postedat = new Date();
        this.postId = postId;
        this.authorId = userId;
    }

    public Comment(String text) { this.text = text; }

    public Long getId() { return id;}
    public void setId (Long id) { this.id =id; }

    public String getText() { return text; }
    public void setText(String commentText) { this.text = text; }

    public Double getLatitude() { return latitude; }
    public void setLatitude (double latitude) { this.latitude = latitude;}

    public Double getLongitude() { return longitude; }
    public void setLongitude (double longitude) { this.longitude = longitude; }

    public Date getPostedat() { return postedat; }
    public void setPostedat() { this.postedat = new Date(); }

    public Long getPostId() { return postId; }
    public void setPostId( Long postId ) { this.postId = postId; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
}