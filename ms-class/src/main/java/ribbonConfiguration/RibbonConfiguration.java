package ribbonConfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//父子上下文不能重叠。不能被 @ComponentScan扫描到
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule  ribbonRule(){
        return new RandomRule();
    }
}
