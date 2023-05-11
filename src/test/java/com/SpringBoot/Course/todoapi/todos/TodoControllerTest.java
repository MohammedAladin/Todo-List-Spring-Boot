package com.SpringBoot.Course.todoapi.todos;


import com.SpringBoot.Course.springnoot.App;
import com.SpringBoot.Course.springnoot.todos.*;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc

public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAll(){
        try {
            mockMvc.perform(get("/api/v1/todos")).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
