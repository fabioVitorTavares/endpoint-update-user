package com.endpointupdateuser.Controller;

import com.endpointupdateuser.Entity.UserEntity;
import com.endpointupdateuser.Service.UserService;
import com.endpointupdateuser.UserDto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControlller {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public Object getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/postUser")
    public Object postUser(@RequestBody @Validated UserDto user){
        return userService.postUser(user);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody @Validated UserEntity user){
        return userService.updateUser(user);
    }
}
