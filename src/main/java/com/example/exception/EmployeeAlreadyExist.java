package com.example.exception;

public class EmployeeAlreadyExist extends RuntimeException{
    private String message;

    public EmployeeAlreadyExist() {
    }

    public EmployeeAlreadyExist(String message) {
        super(message);
        this.message = message;
    }
}
