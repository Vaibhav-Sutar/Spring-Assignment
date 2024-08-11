package com.example.crudtask_accio.exception;

public class CustomerAlreadyExists extends RuntimeException{
    public CustomerAlreadyExists(String message){
        super(message);
    }
}
