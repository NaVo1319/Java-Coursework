package ru.mirea.cursework.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private String tag;
    private int report;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    public String getAuthorName(){
        return author !=null ? author.getUsername():"Неизвестно";
    }

    private Long postId;
}
