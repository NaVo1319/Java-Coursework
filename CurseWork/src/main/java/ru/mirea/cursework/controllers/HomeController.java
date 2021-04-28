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
    int id=0;
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
    @GetMapping("/{id}")
    public String getProfile(Model model, @PathVariable int id){
        return "profile";
    }
    @PostMapping("/")
    public String postHome(@RequestParam String name,@RequestParam String Content) {
        User user=new User(name,Content);
        id++;
        userRepo.save(user);
        return "redirect:/users";
    }
    @PostMapping("/user")
    public User postUser(){
        return new User();
    }
}
