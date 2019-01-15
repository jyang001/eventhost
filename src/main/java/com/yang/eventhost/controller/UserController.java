package com.yang.eventhost.controller;

import com.yang.eventhost.entity.User;
import com.yang.eventhost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/add")
    public String addCustomerForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @GetMapping(value="/delete")
    public String deleteCustomer(@RequestParam int id) {
        userService.deleteUser(id);
        return "/";
    }

}
