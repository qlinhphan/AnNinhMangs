package com.example.springWEB.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageBook {

    @GetMapping("/book")
    public String getMethodName(Model model) {
        return "/client/PageOrderBook";
    }

}
