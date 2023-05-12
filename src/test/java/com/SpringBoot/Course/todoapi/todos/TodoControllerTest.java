package com.SpringBoot.Course.todoapi.todos;


import com.SpringBoot.Course.springnoot.App;
import com.SpringBoot.Course.springnoot.todos.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc

public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoServices todoServices;

    @Test
    public void whenGetAll_returnJsonArray() throws Exception{
        Todo todo1 = new Todo("1", "task1", "this is task1");
        Todo todo2 = new Todo("2", "task2", "this is task2");
        List<Todo> todos = Arrays.asList(todo1, todo2);

       when(todoServices.getAll()).thenReturn(todos);

        mockMvc.perform(get("/api/v1/todos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", equalTo(todo1.getTitle())))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
    }



}