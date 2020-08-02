package com.springcloud.gateway;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 路由谓词工厂必须以RoutePredicateFactory结尾
 *
 * 1 读取配置文件里面的配置,并注入到config参数里面来
 * 2 判断当前时间是否满足要求
 *
 * */
@Component
public class TimeBetweenRoutePredicateFactory
extends AbstractRoutePredicateFactory<TimeConfig>
{
    public TimeBetweenRoutePredicateFactory() {
        super(TimeConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeConfig config) {
        LocalTime startTime = config.getStartTime();
        LocalTime endTime = config.getEndTime();
        LocalTime now = LocalTime.now();
        return serverWebExchange -> {
            return now.isAfter(startTime)&&now.isBefore(endTime);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        //这个可以将配置文件中的 startTime endTime 注入到config中
        return Arrays.asList("startTime","endTime");
    }

    public static void main(String[] args) {

    }
}
