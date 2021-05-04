package ru.mirea.cursework.controllers;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.cursework.entity.Message;
import ru.mirea.cursework.entity.Role;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repo.MessageRepo;
import ru.mirea.cursework.repo.UserRepo;

import java.util.Collections;
@Controller
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;
    @GetMapping("/messages")
    public String getReg(Model model) {
        Iterable<Message> messages=messageRepo.findAll();
        model.addAttribute("messages",messages);
        System.out.println("GET MESSAGE");
        return "messages";
    }
    @PostMapping("/messages")
    public  String postReg(Model model, @RequestParam(name = "author") String author,@RequestParam(name = "text") String text){
        Message mess=new Message();
        mess.setAuthor(author);
        mess.setText(text);
        messageRepo.save(mess);
        System.out.println("POST MESSAGE");
        return "redirect:/messages";
    }
}
