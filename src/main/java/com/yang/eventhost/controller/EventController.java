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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * controller tasked with users abilities to manage events
 */
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

    /**
     * Manages creating a event
     * @param model: used to send the Event object to the jsp
     * @return the event-form
     */
    @GetMapping("/create")
    public String createEventForm(ModelMap model) {
        model.put("logstatus", true);
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
        model.put("logstatus", true);
        Account account = getCurrentAccount();
        model.put("events", account.getEvent());
        return "list-events";
    }


    @PostMapping("/join")
    public String joinEventPost(@ModelAttribute String invitationCode) {
        Account account = getCurrentAccount();
        /* Implement EventService.find Event
         * look for event and return to list events
         * if none found spit out none found
         */
        return "list-events";
    }

    //may need to modify
    @GetMapping("/join")
    public String joinEvent(ModelMap model) {
        model.put("logstatus", true);
        return "event-join";
    }

}
