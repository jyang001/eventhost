package com.yang.eventhost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value="")
    public String showHomePage() {
        return "homepage";
    }

}
