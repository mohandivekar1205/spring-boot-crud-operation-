package com.example.exception;

public class InvalidMailAddressField extends RuntimeException{
    private String message;

    public InvalidMailAddressField() {
    }

    public InvalidMailAddressField(String message) {
        super(message);
    }
}
