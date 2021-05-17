package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.cursework.entity.Message;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repo.MessageRepo;
@Controller
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;
    @GetMapping("/messages")
    public String getReg(@AuthenticationPrincipal User user,Model model) {
        System.out.println(user);
        Iterable<Message> messages=messageRepo.findAll();
        model.addAttribute("messages",messages);
        model.addAttribute("user",user);
        System.out.println("GET MESSAGE");
        return "messages";
    }
    @PostMapping("/messages")
    public  String postReg(@AuthenticationPrincipal User user,
                                       Model model, @RequestParam(name = "author") String author, @RequestParam(name = "text") String text){
        Message mess=new Message();
        mess.setTag(author);
        mess.setText(text);
        mess.setAuthor(user);
        messageRepo.save(mess);
        System.out.println("POST MESSAGE");
        return "redirect:/messages";
    }
}
