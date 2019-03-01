package com.yang.eventhost.controller;

import com.yang.eventhost.entity.Account;
import com.yang.eventhost.entity.Event;
import com.yang.eventhost.service.AccountService;
import com.yang.eventhost.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    AccountService accountService;

    private Account getCurrentAccount() {
         User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         Account account = accountService.findAccountByUsername(user.getUsername());
         return account;
    }

    @GetMapping("/create")
    public String createEventForm(ModelMap model) {
        model.addAttribute("event", new Event());
        return "event-form";
    }

    @PostMapping("/create")
    public String createEventForm(@Valid @ModelAttribute("event") Event event, BindingResult tbr) {
        if (tbr.hasErrors()) {
            List<FieldError> errors = tbr.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return "event-form";
        }
        Account account = getCurrentAccount();
        eventService.createEvent(event, account);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String getEvents(ModelMap model) {
        Account account = getCurrentAccount();
        model.put("events", account.getEvent());
        return "list-events";
    }

}
