package ru.mirea.cursework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mirea.cursework.entity.User;

@Controller
public class HomeController {
    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute User uer, Model model) {
        model.addAttribute("user", uer);
        return "result";
    }
}
