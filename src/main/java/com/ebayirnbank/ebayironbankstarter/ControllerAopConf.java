package com.ebayirnbank.ebayironbankstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class ControllerAopConf {
    @Bean
    public FrontendControllerAdvice frontendControllerAdvice(){
        return new FrontendControllerAdvice();
    }

}
