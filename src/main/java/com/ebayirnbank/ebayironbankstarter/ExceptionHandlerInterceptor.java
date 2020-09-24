package com.ebayirnbank.ebayironbankstarter;

import lombok.SneakyThrows;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */

public class ExceptionHandlerInterceptor implements MethodInterceptor {

    @Autowired
    private RavenSender ravenSender;



    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        try {
            return methodInvocation.proceed();
        } catch (NotEnoughMoneyException ex) {
            ravenSender.sendRaven(ex);
            throw ex;
        }
    }
}





