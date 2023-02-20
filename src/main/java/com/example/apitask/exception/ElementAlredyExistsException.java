package com.example.apitask.exception;

public class ElementAlredyExistsException  extends  RuntimeException{
    public ElementAlredyExistsException(String message) {
        super(message+"already exists in the database");
    }
}
