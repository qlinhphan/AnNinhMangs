package com.example.springWEB.controller.authen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.springWEB.domain.User;
import com.example.springWEB.domain.dto.UserRegisterDTO;
import com.example.springWEB.service.RoleService;
import com.example.springWEB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyAuthenControll {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String regist(Model model, @ModelAttribute("newRegis") UserRegisterDTO ur) {
        return "/authen/register";
    }

    @PostMapping("/register")
    public String registerok(Model model, @ModelAttribute("newRegis") UserRegisterDTO ur) {
        if (ur.getPassword().equals(ur.getRePassword())) {
            User us = this.userService.createUserFromDTO(ur);
            this.userService.saveUser(us);
            return "ok";
        }
        model.addAttribute("message", "Passwords do not match!");
        return "false";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/authen/login";
    }

    @GetMapping("/access-deny")
    public String deny(Model model) {
        return "/client/deny";
    }

}
