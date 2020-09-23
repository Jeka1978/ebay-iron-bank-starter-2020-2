package com.ebayirnbank.ebayironbankstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ConditionalOnProd
@ConditionalOnProperty("raven.destination")
@EnableConfigurationProperties(RavenProps.class)
public class RavenConf {



    @Bean(name = "notEnoughMoneyExceptionHandler")
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }

    @Bean
    public RavenSender ravenSender(){
        return new RavenSender();
    }


}
