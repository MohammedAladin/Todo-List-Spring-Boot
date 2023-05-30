package com.SpringBoot.Course.springnoot.Services;


import com.SpringBoot.Course.springnoot.Repositry.TodoRepo;
import com.SpringBoot.Course.springnoot.error.ConflictException;
import com.SpringBoot.Course.springnoot.error.NotFoundException;
import com.SpringBoot.Course.springnoot.Models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoServices {

    @Autowired
    private TodoRepo todoRepo;

    public List<Todo> getAll() {
        List<Todo> list =  todoRepo.findAll();
        return  list;

    }
    public Todo getById(String id){
        try {
            return todoRepo.findById(id).get();
        }catch (NoSuchElementException ex){
            throw new NotFoundException(String.format("No Record with this id has been found -- ", id));
        }

    }

    public Todo create(Todo todo){
        if(todoRepo.findByTitle(todo.getTitle())!=null) {
            throw new ConflictException("There is a Todo with the same title please choose another title");
        }
        return todoRepo.insert(todo);
    }
    public void deleteById(String id){
        todoRepo.deleteById(id);
    }
}
