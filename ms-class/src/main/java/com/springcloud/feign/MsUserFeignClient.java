package com.springcloud.feign;

import com.springcloud.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//FEIGN 底层带上了ribbon功能
@FeignClient(name = "ms-user"/*,configuration = MsUserFeignClientConfiguration.class*/)
public interface MsUserFeignClient {
    @GetMapping("/users/{userId}")
    UserDto findUserById(@PathVariable("userId") int userId);
}
