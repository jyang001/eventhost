package com.yang.eventhost.controller;

import com.yang.eventhost.entity.Group;
import com.yang.eventhost.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @GetMapping("/create")
    public String createGroupForm(ModelMap model) {
        model.addAttribute("group", new Group());
        return "group-form";
    }

}
