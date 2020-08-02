package com.springcloud.domain;

import lombok.Data;

@Data
public class Book {
    private String name;
    private int price;
    private String author;
    private String publisher;

}
