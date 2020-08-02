package com.springcloud.controller;

import com.springcloud.domain.entity.Lesson;
import com.springcloud.service.LessonService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    //@RateLimiter(name = "buyById",fallbackMethod = "buyByIdFallback")  //限流
   // @CircuitBreaker(name = "buyById",fallbackMethod = "buyByIdFallback") //断路器模式
    @Bulkhead(name = "buyById",fallbackMethod = "buyByIdFallback",type = Bulkhead.Type.SEMAPHORE) //仓壁模式 默认用的是 SEMAPHORE (信号量)   如果想用线程池就 type = Bulkhead.Type.THREADPOOL
    public Lesson buyBuyId(@PathVariable int id){
        return lessonService.buyById(id);
        //1.根据ID查询lesson
        //2.根据lesson.id查询user_lesson ,如果有直接返回如果没有
        //3.如果user_lesson==null &&用户的余额>lesson.price,就去购买
    }

    public  Lesson buyByIdFallback(int id,Throwable throwable){
        System.out.println("发生fallback"+throwable.getMessage());
        return new Lesson();
    }
}
