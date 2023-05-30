package com.SpringBoot.Course.springnoot.security;

import com.SpringBoot.Course.springnoot.todos.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.ListDataEvent;
import java.util.List;

@RequestMapping("/api/auth/")
@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public AppUser create(@RequestBody AppUser user){
        return userService.AddUser(user);
    }
    @GetMapping("/{id}")
    public AppUser getById(@PathVariable String id){
        return userService.getUserById(id);
    }
    @GetMapping("/")
    public List<AppUser> getAll(){
        return userService.getAll();
    }

}
