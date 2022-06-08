package com.learn.rabbit.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
}
