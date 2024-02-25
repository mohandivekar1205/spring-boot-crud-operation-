package com.example.exception;

public class InvalidMobileNumberField extends RuntimeException{

    private String message;

    public InvalidMobileNumberField(){
    }
    public InvalidMobileNumberField(String message) {
        super(message);
    }
}
