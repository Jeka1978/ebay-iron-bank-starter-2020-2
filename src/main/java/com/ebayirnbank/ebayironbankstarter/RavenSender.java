package com.ebayirnbank.ebayironbankstarter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */
public class RavenSender {


    @Autowired
    private RavenProps ravenProps;

    public void sendRaven(NotEnoughMoneyException ex) {
        System.out.println("raven was sent to "+ravenProps.getDestination());
        System.out.println("raven was sent message is "+ex.getMessage());
    }



}
