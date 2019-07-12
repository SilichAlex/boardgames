package com.boardgames.userservice.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "user")
@Entity
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
