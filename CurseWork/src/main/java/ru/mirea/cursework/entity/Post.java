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
    Long id;
    String name;
    String text;
    String imgUrl;
    Long views;
    Double rating;
    Long reports;
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    List<Message> messages;
}
