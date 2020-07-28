package com.springcloud.controller;

import com.springcloud.domain.entity.Lesson;
import com.springcloud.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    //购买指定id的课程
    @RequestMapping("/buy/{id}")
    public Lesson buyBuyId(@PathVariable int id){
        return lessonService.buyById(id);
        //1.根据ID查询lesson
        //2.根据lesson.id查询user_lesson ,如果有直接返回如果没有
        //3.如果user_lesson==null &&用户的余额>lesson.price,就去购买
    }
}
