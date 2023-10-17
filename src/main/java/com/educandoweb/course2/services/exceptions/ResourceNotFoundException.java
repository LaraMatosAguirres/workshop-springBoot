package com.educandoweb.course2.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    private static final  long serialVersionUID = 1l;

    public ResourceNotFoundException(Object id){
        super("Resouce not found. Id " + id);
    }
}
