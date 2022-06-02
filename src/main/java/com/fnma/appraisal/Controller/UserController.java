package com.fnma.appraisal.Controller;

import com.fnma.appraisal.Entity.User;
import com.fnma.appraisal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // User API

    @GetMapping ("/users")
    public List<User> getUser(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/users/{userID}")
    public User getuser(@PathVariable String userID){
        return this.userService.getUserByID(Integer.parseInt(userID));
    }
    @PostMapping("/users")
    public User adduser(@RequestBody User user){
        return this.userService.addUser(user);
    }
    @PutMapping("/users")
    public User updateuser(@RequestBody User user){
        return this.userService.updateUser(user);
    }
    @DeleteMapping("/users/{userID}")
    public String deleteuser(@PathVariable String userID){
        return this.userService.deleteUserByID(Integer.parseInt(userID));
    }
}
