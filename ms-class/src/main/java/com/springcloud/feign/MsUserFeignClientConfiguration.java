package com.springcloud.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 不需要加上@configuration注解
 * 否则必须放到启动类所在包只外（@componentScan能够扫描的包之外）
 * 否则就会被所有的feign client共享
 */
public class MsUserFeignClientConfiguration {
    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }

}
