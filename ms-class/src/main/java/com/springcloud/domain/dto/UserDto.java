package com.springcloud.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserDto {
    private int id;

    private String username;
    private  String password;
    private BigDecimal money;
    private String role;
    private Date regTime;
}
