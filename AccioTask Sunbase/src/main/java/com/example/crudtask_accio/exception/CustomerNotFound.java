package com.example.crudtask_accio.exception;

public class CustomerNotFound extends RuntimeException{

    public CustomerNotFound(String message){
        super(message);
    }
}
