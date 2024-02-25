package com.example.exception;

public class InvalidSalaryField extends  RuntimeException{

    private String message;

    public InvalidSalaryField(String message) {
        this.message = message;
    }

    public InvalidSalaryField() {
    }


}
