//package com.test.controller;
//
//import com.test.dto.UserDto;
//import org.springframework.web.bind.annotation.*;
//
//@RestController // json xml
//@RequestMapping("/api")
//public class HelloController {
//
//    @GetMapping()
//    public String Home() {
//        return "Hello Welcome!!";
//    }
//
//    @GetMapping("/getUser")
//    public String Hello(@RequestParam String Name) {
//        return "Hello " + Name;
//    }
//
//    @GetMapping("/getUser/data")
//    public String Hellos(@RequestParam String name, @RequestParam String add) {
//        return "Hello " + name + ": " + add;
//    }
//
//
//    @PostMapping("/post/data")
//    public UserDto userData(@RequestBody UserDto userDto) {
//        String name = "              helooaw   dfjnd";
//
////        System.out.println(userDto);
//        System.out.println(name.trim().substring(5));
//        return userDto;
//    }
//
//
//}
