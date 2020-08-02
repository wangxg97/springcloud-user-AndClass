package com.springcloud;

import com.springcloud.feign.MsUserFeignClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//feign的 代码的全局配置就用 defaultConfiguration属性
@EnableFeignClients
//(defaultConfiguration = MsUserFeignClientConfiguration.class)
public class MsClassApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsClassApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
