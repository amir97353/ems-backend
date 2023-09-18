package net.javaguides.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
//this code defines a custom exception class, ResourceNotFoundException, that is used in a Spring-based application to represent situations where a requested resource could not be found. When this exception is thrown, it will result in an HTTP response with a status code of 404 (Not Found), and the provided message can be used to provide additional information about the nature of the resource not being found.