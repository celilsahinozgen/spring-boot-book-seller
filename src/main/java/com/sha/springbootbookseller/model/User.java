package com.sha.springbootbookseller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username" , unique = true, length = 100)
    private String username;

    @Column(name = "password", nullable = false ,length = 100)
    private String password;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

    // normalde buradaki deger int tir, String olarak verirsek manuel vercez
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Transient
    private String token;
}
