package com.example.demoweb.com.example.demoweb.service;

import com.example.demoweb.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<Post>() {{
        add(new Post("123", new Date()));
        add(new Post("Sosiska", new Date()));
        add(new Post("Java the best!1", new Date()));
    }};

    public List<Post> listAllPosts(){
        return posts;
    }

    public void create(String text) {
        posts.add(new Post(text, new Date()));
    }

}
