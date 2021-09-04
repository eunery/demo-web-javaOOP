package com.example.demoweb.model;

public class Post {
    private String text;
    private Integer likes;

    public Post(String text){
        this.text = text;
        this.likes = 0;
    }

    public Integer getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }
}
