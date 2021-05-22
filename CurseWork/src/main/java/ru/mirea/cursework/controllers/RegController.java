package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.cursework.entity.Role;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repo.UserRepo;

import java.util.Collections;

@Controller
public class RegController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String getReg() {
        return "registration";
    }
    @PostMapping("/registration")
    public  String postReg(Model model, User user, @RequestParam(name = "username") String username,@RequestParam(name = "password") String password,
                           @RequestParam(name = "email") String email ){
        User UserDB = userRepo.findByUsername(username);
        if (UserDB!=null){
            model.addAttribute("messageRegistration","Пользователь уже существует");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userRepo.save(user);
        return "redirect:/";
    }
}
