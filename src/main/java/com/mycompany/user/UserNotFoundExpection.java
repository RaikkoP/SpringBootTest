package com.mycompany.user;

public class UserNotFoundExpection extends Throwable {
    public UserNotFoundExpection(String message) {
        super(message);
    }
}
