package com.yang.eventhost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    public static boolean loggedIn = false;

    @GetMapping(value="/")
    public String showHomePage(ModelMap model) {
        model.put("logstatus",loggedIn);
        return "index";
    }

}
