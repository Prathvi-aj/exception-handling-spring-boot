package com.springexception.exceptionhandling.controller;

import com.springexception.exceptionhandling.dto.UserDto;
import com.springexception.exceptionhandling.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springexception.exceptionhandling.services.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserDto> getData(){
        return userService.getUserDetails();
    }

    @GetMapping("/user/{userId}")
    public UserDto getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/save-user")
    public void saveData(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @GetMapping("/get-user")
    public String getUser(Principal principal){
        return principal.getName();
    }
}
