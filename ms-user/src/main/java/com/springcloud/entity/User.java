package com.springcloud.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private  String password;
    @Column
    private BigDecimal money;
    @Column
    private String role;
    @Column
    private Date regTime;
}
