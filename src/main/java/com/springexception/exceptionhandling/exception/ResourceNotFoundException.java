package com.springexception.exceptionhandling.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName,String fieldValue){
        super(String.format("%s not found %s: %s",resourceName,fieldName,fieldValue));
        this.fieldName=fieldName;
        this.resourceName=resourceName;
        this.fieldValue=fieldValue;
    }

}
