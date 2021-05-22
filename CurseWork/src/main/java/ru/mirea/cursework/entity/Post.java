package ru.mirea.cursework.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public",name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String text;
    private String imgUrl;
    private Long views;
    private Double rating;
    private Long reports;
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    List<Message> messages;
    public Post(){
        rating=0.0;
        views=(long) 0;
    }

    public Post( String name, String text, String imgUrl, Long views, Double rating, Long reports, List<Message> messages) {
        this.name = name;
        this.text = text;
        this.imgUrl = imgUrl;
        this.views = views;
        this.rating = rating;
        this.reports = reports;
        this.messages = messages;
    }

    public void view(){
        views++;
    }
    public void  updateRating(){
        int i=0;
        for(Message message : messages){
            i+=message.getReport();
        }
        rating=i/messages.size()+0.0;
    }
    public void addMessage(Message message){
        messages.add(message);
    }
}
