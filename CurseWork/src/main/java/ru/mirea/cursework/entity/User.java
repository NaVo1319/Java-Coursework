package ru.mirea.cursework.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "public",name = "users")
@Data
public class User {
    @Id
    @SequenceGenerator(name="users_generator", sequenceName="users_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_generator")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    public User(){}
    public User(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
