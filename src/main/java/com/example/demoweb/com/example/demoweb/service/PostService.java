package com.example.demoweb.com.example.demoweb.service;

import com.example.demoweb.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    public List<Post> listAllPosts(){
        List<Post> CountPost = new ArrayList<Post>() {{
            add(new Post("123"));
            add(new Post("Piska"));
            add(new Post("Java the best!1"));
        }};
        return CountPost;
    }

}
