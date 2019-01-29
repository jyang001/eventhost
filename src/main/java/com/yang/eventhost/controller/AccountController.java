package com.yang.eventhost.controller;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class AccountController {

    @Autowired
    AccountService accountService;

    private Account currentAccount;

    @GetMapping(value="/signup")
    public String addCustomerForm(ModelMap model) {
        model.addAttribute("account", new Account());
        return "user-form";
    }

    @GetMapping(value="/login")
    public String loginForm(ModelMap model) {
        model.addAttribute("user", new Account());
        return "login";
    }

    @GetMapping("/login/error")
    public String loginError(ModelMap model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @PostMapping(value="/signup")
    public String addCustomerForm(ModelMap model, @Valid @ModelAttribute("account") Account account, BindingResult tbr) {

        if (tbr.hasErrors()) {
            List<FieldError> errors = tbr.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return "user-form" ;
        }
        accountService.saveAccount(account);
        HomeController.loggedIn=true;
        return"redirect:/";
    }
    /*
    @PostMapping(value="/login")
    public String loginForm(ModelMap model, @Valid @ModelAttribute("account") Account account) {
        System.out.println("finished");
        HomeController.loggedIn=true;
        System.out.println(HomeController.loggedIn);
        return"redirect:/user/signup";
    }
    */

}
