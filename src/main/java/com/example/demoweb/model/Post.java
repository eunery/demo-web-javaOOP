package com.example.demoweb.model;

import java.util.Date;

public class Post {
    private String text;
    private Date creationDate;
    private Integer likes;
    private Long id;

    public Post(String text,Date creationDate, Long id){
        this.id = id;
        this.text = text;
        this.likes = 0;
        this.creationDate = creationDate;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public Integer getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
