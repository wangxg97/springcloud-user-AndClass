package com.springcloud.gateway;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimeConfig {
    private LocalTime startTime;
    private LocalTime endTime;

}
