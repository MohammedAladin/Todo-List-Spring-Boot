package com.SpringBoot.Course.springnoot.Controllers;

import com.SpringBoot.Course.springnoot.Models.Todo;
import com.SpringBoot.Course.springnoot.Services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/todos")
@RestController

public class TodoController {

    @Autowired
    TodoServices todoServices;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Todo>> listTodos(){
        List<Todo> list =  todoServices.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable String id){
        Todo todo = todoServices.getById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Todo> createNewTodo(@Valid @RequestBody Todo todo){
        Todo result = todoServices.create(todo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
    @GetMapping(value = {"/delete"})
    public ResponseEntity<Void> delete(@RequestParam String id){
        todoServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
