package com.springcloud.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "lesson")
@Entity
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column
    private String title;
    @Column
    private  String cover;
    @Column
    private BigDecimal price;
    @Column
    private String description;
    @Column
    private Date createTime;
    @Column
    private String videoUrl;
}
