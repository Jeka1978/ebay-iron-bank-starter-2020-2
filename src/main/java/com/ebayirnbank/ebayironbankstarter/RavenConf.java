package com.ebayirnbank.ebayironbankstarter;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ConditionalOnProd
@ConditionalOnProperty("raven.destination")
@EnableConfigurationProperties(RavenProps.class)
public class RavenConf {

    @Bean
    public CustomPointcut customPointcut(){
        return new CustomPointcut();
    }

    @Bean(name = "notEnoughMoneyExceptionHandler")
    public ExceptionHandlerInterceptor exceptionHandlerAspect(){
        return new ExceptionHandlerInterceptor();
    }

    @Bean
    public DefaultPointcutAdvisor myDefaultPointcutAdvisor(){
        return new DefaultPointcutAdvisor(customPointcut(), exceptionHandlerAspect());
    }

    @Bean
    public RavenSender ravenSender(){
        return new RavenSender();
    }

}








