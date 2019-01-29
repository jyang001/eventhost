package com.yang.eventhost.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    public static boolean loggedIn = false;

    private boolean isUserLoggedIn()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails;
    }

    @GetMapping(value="/")
    public String showHomePage(ModelMap model) {
        System.out.println(isUserLoggedIn() + "YESSSS LOGGED IN");
        if (isUserLoggedIn() || loggedIn) {
            model.put("logstatus", true);
        }
        return "index";
    }

}
