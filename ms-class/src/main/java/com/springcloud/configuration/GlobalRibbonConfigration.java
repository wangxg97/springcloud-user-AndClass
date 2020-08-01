package com.springcloud.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import ribbonConfiguration.RibbonConfiguration;

//ribbon的全局配置
@Configuration
@RibbonClients(defaultConfiguration= RibbonConfiguration.class )
public class GlobalRibbonConfigration {
}
