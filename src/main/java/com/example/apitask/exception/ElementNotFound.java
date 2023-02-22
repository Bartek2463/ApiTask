package com.example.apitask.exception;

public class ElementNotFound  extends RuntimeException{
    public ElementNotFound(String model,String value,String input) {
        super(model+"Not found with given "+value+" :"+input);
    }
}
