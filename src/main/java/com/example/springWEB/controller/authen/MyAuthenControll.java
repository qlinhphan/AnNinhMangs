package com.example.springWEB.controller.authen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyAuthenControll {

    @GetMapping("/register")
    public String getMethodName(Model model) {
        return "/authen/register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/authen/login";
    }

}
