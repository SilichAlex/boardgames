package com.boardgames.userservice.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean active;

}
