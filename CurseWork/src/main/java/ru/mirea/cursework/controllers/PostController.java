package ru.mirea.cursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.cursework.entity.Message;
import ru.mirea.cursework.entity.Post;
import ru.mirea.cursework.entity.User;
import ru.mirea.cursework.repo.MessageRepo;
import ru.mirea.cursework.repo.PostRepo;

import java.util.*;


@Controller
public class PostController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
     private PostRepo postRepo;
    @GetMapping("/posts")
    public String getPostsTop(Model model,@AuthenticationPrincipal User user){
        ArrayList<Post> posts=new ArrayList<>();
        postRepo.findAll().forEach(posts::add);
        Collections.sort(posts, (a,b)-> b.getRating().compareTo(a.getRating()));
        model.addAttribute("posts",posts);
        model.addAttribute("user",user);
        return "posts";
    }
    @GetMapping("/addpost")
    public String getAddPost(@AuthenticationPrincipal User user,Model model){
        model.addAttribute("user",user);
        return "addpost";
    }
    @PostMapping("/addpost")
    public String addPost(Model model, @AuthenticationPrincipal User user,
                          @RequestParam("name") String name,@RequestParam("text") String text, @RequestParam("img") String img){
        model.addAttribute("user",user);
        Post post=new Post();
        post.setName(name);
        post.setText(text);
        post.setImgUrl(img);
        postRepo.save(post);
        return "addpost";
    }
    @GetMapping("/posts/{id}")
    public String getPostId(Model model, @PathVariable("id") Long id,@AuthenticationPrincipal User user){
        Optional<Post> optionalPost=postRepo.findById(id);
        Post post=optionalPost.isPresent() ? optionalPost.get() : new Post();
        post.view();
        postRepo.save(post);
        model.addAttribute("post",post);
        model.addAttribute("user",user);
        model.addAttribute("messages",post.getMessages());
        return "post";
    }
    @PostMapping("/posts/{id}")
    public String setPostId(@AuthenticationPrincipal User user, Model model, @PathVariable("id") Long id, @RequestParam("rating") int rating,
    @RequestParam(name = "name") String author, @RequestParam(name = "text") String text){
        Optional<Post> optionalPost=postRepo.findById(id);
        Post post=optionalPost.isPresent() ? optionalPost.get() : new Post();
        Message mess=new Message();
        mess.setTag(author);
        mess.setText(text);
        mess.setAuthor(user);
        mess.setReport(rating);
        post.addMessage(mess);
        post.updateRating();
        postRepo.save(post);
        return "redirect:/posts";
    }
}
