package com.scheduler.controller;

import com.scheduler.payload.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class UserController {
    @PostMapping("/user")
    public UserDto takeDetails(@RequestBody UserDto userDto) {
        return userDto;
    }
}
