package com.springcloud.service;

import com.springcloud.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

//feign的继承特性
public interface HelloService {

    @GetMapping(value = "helllo")
    String hello(@RequestParam("name") String name);

    @GetMapping(value = "hello2")
    Book hello(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("price") int price) throws UnsupportedEncodingException;

    @PostMapping(value = "hello3")
    String hello(@RequestBody Book book);
}
