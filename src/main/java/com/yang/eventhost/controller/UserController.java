package com.yang.eventhost.controller;

import com.yang.eventhost.entity.User;
import com.yang.eventhost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/signup")
    public String addCustomerForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @GetMapping(value="/delete")
    public String deleteCustomer(@RequestParam int id) {
        userService.deleteUser(id);
        return "/";
    }

    @PostMapping(value="/signup")
    public String addCustomerForm(ModelMap model, @Valid @ModelAttribute("user") User user, BindingResult tbr) {
        if (tbr.hasErrors()) {
            return "user-form" ;
        }
        userService.addUser(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), user.getEmail());
        HomeController.loggedIn=true;
        return"/";
    }
}
