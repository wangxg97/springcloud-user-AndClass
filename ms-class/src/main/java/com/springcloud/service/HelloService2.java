package com.springcloud.service;

import com.springcloud.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

//这个接口中不需要添加任何方法，方法都在父接口中，
// 这里只需要在类上面添加@FeignClient("ms-user")注解来绑定服务即可。

@FeignClient(name = "ms-user",contextId = "extendFeign")
public interface HelloService2 extends HelloService {
}
