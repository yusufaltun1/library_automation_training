package com.library.controller;

import com.library.dto.CreateUserForm;
import com.library.entity.UserEntity;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String gotoUsers(Model model)
    {
        List<UserEntity> users = userService.getAll();
        model.addAttribute("users", users);
        model.addAttribute("createUserForm", new CreateUserForm());

        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String createUser(@ModelAttribute CreateUserForm createUserForm)
    {
        userService.createUser(createUserForm);
        return "redirect:/users";
    }
}
