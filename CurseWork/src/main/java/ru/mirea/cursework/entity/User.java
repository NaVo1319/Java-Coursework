package ru.mirea.cursework.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "public",name = "users")
@Data
public class User {
    @Id
    //@SequenceGenerator(name="users_generator", sequenceName="users_id_seq", allocationSize=1)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_generator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private boolean active;
    @Column(name = "email")
    private String email;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
