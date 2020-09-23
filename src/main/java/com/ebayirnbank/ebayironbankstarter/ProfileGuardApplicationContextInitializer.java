package com.ebayirnbank.ebayironbankstarter;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Evgeny Borisov
 */
public class ProfileGuardApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        if (environment.getActiveProfiles().length == 0) {
            throw new IllegalStateException("you can't run your app without profile");
        }
    }
}
