package com.users.data.management.controller;

import com.users.data.management.payload.UserDto;
import com.users.data.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/get/user/data")
    public UserDto getUserData(@RequestParam Long id) {
        return userService.getUserData(id);
    }

    @PutMapping("/update/user/data")
    public UserDto updateUserData(@RequestBody UserDto userDto) {
        return userService.updateUserData(userDto);
    }

}
