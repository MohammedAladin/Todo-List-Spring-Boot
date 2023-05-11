package com.SpringBoot.Course.todoapi.todos;

import com.SpringBoot.Course.springnoot.error.NotFoundException;
import com.SpringBoot.Course.springnoot.todos.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

public class TodoServiceTest {

    @Mock
    TodoRepo todoRepository;

    @InjectMocks
    TodoServices todoServices;


    @Test
    public void whenFindAll_ReturnTodoList() {
        Todo todo1 = new Todo("1", "task1", "this is task1");
        Todo todo2 = new Todo("2", "task2", "this is task2");
        List<Todo> todos = Arrays.asList(todo1, todo2);

        Mockito.when(todoRepository.findAll()).thenReturn(todos);

        assertThat(todoServices.getAll()).hasSize(2).contains(todo1, todo2);

    }

    @Test
    public void whenGetById_returnTodoWithThisId() {
        Todo todo1 = new Todo("1", "Todo 1", "this is task1");
        Todo todo2 = new Todo("2", "task2", "this is task2");

        when(todoRepository.findById(anyString())).thenReturn(Optional.ofNullable(todo1));
        Todo result = todoServices.getById("1");
        assertThat(result.getTitle()).contains("Todo 1");

    }
    @Test
    public void whenInvalid_todoShouldBeNotFound () {
        given(todoRepository.findById(anyString())).willReturn(Optional.empty());

        assertThatExceptionOfType(NotFoundException.class).isThrownBy(() -> todoServices.getById("1"));

    }

}
