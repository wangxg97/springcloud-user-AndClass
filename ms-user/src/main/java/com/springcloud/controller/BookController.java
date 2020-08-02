package com.springcloud.controller;

import com.springcloud.domain.Book;
import com.springcloud.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

//服务提供者实现了helloservice中的方法以后，就不需要在方法上添加@requestmapping注解了
//这些注解在父接口中都有，但是controller上的 @RestController还是不能少
@RestController
public class BookController implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name + "!";
    }

    @Override
    public Book hello(String name, String author, int price) throws UnsupportedEncodingException {
        Book book = new Book();
        book.setName(URLDecoder.decode(name,"UTF-8"));
        book.setAuthor(URLDecoder.decode(author,"UTF-8"));
        book.setPrice(price);
        System.out.println(book);
        return book;
    }

    @Override
    public String hello(Book book) {
        return "书名为：" + book.getName() + ";作者为：" + book.getAuthor();
    }
}
