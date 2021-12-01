package com.example.demoweb;

import com.example.demoweb.com.example.demoweb.service.LikesService;
import com.example.demoweb.model.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class LikeControllerTest {
    @Autowired
    LikesService likesService;
    @Test
    public void likeSetTest(){ // проверка что будет если создать тест с двумя лайками
        Post post = new Post(1L, "Test post",new Date()); // создаем пост
        post.setLikes(2); // устанавливаем кол-во лайков
        Assert.assertEquals(java.util.Optional.ofNullable(post.getLikes()), java.util.Optional.of(2));
        // проверка на установленные лайки
    }
}
