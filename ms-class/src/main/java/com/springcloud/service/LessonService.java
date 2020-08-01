package com.springcloud.service;


import com.springcloud.domain.dto.UserDto;
import com.springcloud.domain.entity.Lesson;
import com.springcloud.domain.entity.LessonUser;
import com.springcloud.feign.MsUserFeignClient;
import com.springcloud.repository.LessonRepository;
import com.springcloud.repository.LessonUserReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private LessonUserReposity lessonUserReposity;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MsUserFeignClient msUserFeignClient;

    public Lesson buyById(int id){



        //1.根据ID查询lesson
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("该课程不存在"));

        //2.根据lesson.id查询user_lesson,如果没有
        LessonUser lessonUser = lessonUserReposity.findByLessonId(id);
        if (lessonUser!=null){
            return lesson;
        }
        //3.如果user_lesson==null&&用户的余额》lesson.price,购买
        UserDto userDto = msUserFeignClient.findUserById(1);

      //UserDto userDto = restTemplate.getForObject("http://ms-user/users/{userId}", UserDto.class, "1");

        BigDecimal money = userDto.getMoney().subtract(lesson.getPrice());
        if (money.compareTo(BigDecimal.ZERO)<0){
            throw  new  IllegalArgumentException("余额不足");
        }

        //TODO 购买逻辑 1 调用用户微服务的扣减金额接口 2 向lesson_user表中添加一条数据
        return lesson;
    }
}
