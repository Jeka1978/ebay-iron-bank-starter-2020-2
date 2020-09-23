package com.ebayirnbank.ebayironbankstarter;

import lombok.SneakyThrows;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
@Aspect
public class ExceptionHandlerAspect {

    @Autowired
    private RavenSender ravenSender;



    @AfterThrowing(pointcut = "execution(* com.ebay.demoironbank.services..*.*(..))",throwing = "ex")
    public void handleNotEnoughMoneyException(NotEnoughMoneyException ex) {
       ravenSender.sendRaven(ex);
    }

    @SneakyThrows
    public static void main(String[] args) {
        Method toUpperCase = String.class.getMethod("toUpperCase");
        System.out.println(toUpperCase);
    }
}


