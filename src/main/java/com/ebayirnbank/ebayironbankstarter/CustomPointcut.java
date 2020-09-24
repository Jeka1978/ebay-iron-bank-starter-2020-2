package com.ebayirnbank.ebayironbankstarter;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class CustomPointcut extends DynamicMethodMatcherPointcut {
    @Autowired
    private RavenProps ravenProps;

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass -> aClass.getPackage().getName().contains(ravenProps.getPackageToScan());
    }
}
