package com.security.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("say")
    public Object say(){
        return "{hello  word}";
    }
}
