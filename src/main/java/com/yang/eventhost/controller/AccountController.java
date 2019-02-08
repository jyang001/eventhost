package com.yang.eventhost.controller;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        return"redirect:/user/login";
    }

    @GetMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

}
