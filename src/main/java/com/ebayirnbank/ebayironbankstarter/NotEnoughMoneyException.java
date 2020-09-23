package com.ebayirnbank.ebayironbankstarter;

/**
 * @author Evgeny Borisov
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
