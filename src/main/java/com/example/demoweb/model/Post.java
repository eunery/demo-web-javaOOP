package com.example.demoweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private int likes;
    private Date creationDate;

    public Post() {

    }

    public Post(Long id, String text, Date creationDate)
    {
        this.id = id;
        this.text = text;
        this.creationDate = creationDate;
        this.likes = 0;
    }

    public String getText() {
        return text;
    }

    public Integer getLikes(){
        return likes;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setLikes(int value) {
        this.likes = value;
    }

    public Long getId(){
        return this.id;
    }

}
