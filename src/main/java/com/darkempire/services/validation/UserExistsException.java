package com.darkempire.services.validation;

/**
 * Created by Сергій on 28.10.2014.
 */
public class UserExistsException extends Exception {
    public UserExistsException(String message) {
        super(message);
    }
}
