package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.cursework.entity.Post;
import ru.mirea.cursework.entity.Role;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repo.PostRepo;
import ru.mirea.cursework.repo.UserRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;
    @GetMapping("/")
    public String getHome(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        if(user!=null){
            if (user.getRoles().contains(Role.ADMIN)) {
                model.addAttribute("userRole",1);
            }
            else{
                model.addAttribute("userRole",0);
            }
        }
        else{
            model.addAttribute("userRole",0);
        }
        ArrayList<Post> posts=new ArrayList<>();
        postRepo.findAll().forEach(posts::add);
        Collections.sort(posts, (a, b)-> b.getRating().compareTo(a.getRating()));
        model.addAttribute("post1",posts.get(0));
        model.addAttribute("post2",posts.get(1));
        model.addAttribute("post3",posts.get(2));
        return "home";
    }
    @GetMapping("/users")
    public String getUsers(Model model){
        Iterable<User> users= userRepo.findAll();
        model.addAttribute("users", users);
        System.out.println("USERS");
        return "users";
    }


    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
