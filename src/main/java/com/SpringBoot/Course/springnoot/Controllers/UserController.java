package com.SpringBoot.Course.springnoot.Controllers;

import com.SpringBoot.Course.springnoot.Models.AppUser;
import com.SpringBoot.Course.springnoot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
