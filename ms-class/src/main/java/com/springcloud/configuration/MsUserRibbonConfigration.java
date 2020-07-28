package com.springcloud.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import ribbonConfiguration.RibbonConfiguration;

//课程微服务调用用户微服务的时候调用这个配置类
@Configuration
@RibbonClient(name = "ms-user",configuration = RibbonConfiguration.class )
public class MsUserRibbonConfigration {
}
