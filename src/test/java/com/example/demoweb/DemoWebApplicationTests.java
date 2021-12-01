package com.example.demoweb;

import com.example.demoweb.controller.PostsViewController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // в аннотации, которая производит тестирование, указываем окружение, которое будет запускать тесты
@AutoConfigureMockMvc // автоматическое создание структуры классов которая подменяет слой MVC из spring, будет создано окружение
@TestPropertySource("/application-test.properties") // указываем настройки для тестов
@Sql(value = {"/create-post-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD) // выполнить sql перед
@Sql(value = {"/create-post-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD) // выполнить sql после
@SpringBootTest // запускаем тесты в окружении spring boot app
public class DemoWebApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception { // проверки на содержание какого-либо контента
		this.mockMvc.perform(get("/"))
				.andDo(print()) // вывод в консоль
				.andExpect(status().isOk()) // возврат статуса gethttp = 200
				.andExpect(content().string(containsString("Мое супер приложение"))); // содержит подстроку
		this.mockMvc.perform(get("/new"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Добавить новый пост")));
	}

	@Autowired
	private PostsViewController controller;

	@Test
	public void postsListDbTest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print()) // вывод в консоль
				.andExpect(xpath(".//div[@class='content']/div").nodeCount(2));
		// ищем в дереве элемент с классом 'content' и, то что у нас таких элемента 2
	}
}
