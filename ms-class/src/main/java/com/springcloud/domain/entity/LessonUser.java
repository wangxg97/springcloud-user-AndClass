package com.springcloud.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "lesson_user")
@Entity
@Data
public class LessonUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private int lessonId;
    @Column
    private int userId;
}
