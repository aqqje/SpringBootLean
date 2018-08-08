package com.aqqje.resetfulcrud.exception;

public class UserException extends RuntimeException{

    public UserException() {
        super("用户不存在！");
    }
}
