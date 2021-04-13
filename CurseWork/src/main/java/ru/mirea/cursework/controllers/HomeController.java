package ru.mirea.cursework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mirea.cursework.entity.User;

import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<User> users=new ArrayList<>();
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/")
    public String postHome(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        users.add(user);
        System.out.println(users);
        return "result";
    }
}
