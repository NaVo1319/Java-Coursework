package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repo.UserRepo;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }
    @GetMapping("/users")
    public String getUsers(Model model){
        Iterable<User> users= userRepo.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
