package com.example.springWEB.controller.admin.introduceApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroduceApp {

    @GetMapping("/introduce")
    public String introduce(Model model) {
        return "/admin/introduceApp";
    }

}
