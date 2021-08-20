package com.pablintino.services.commons.exceptions;

import lombok.Getter;

public class GenericHttpServiceException extends RuntimeException {

    @Getter
    private final int status;

    public GenericHttpServiceException(String message){
        super(message);
        this.status = 500;
    }

    public GenericHttpServiceException(String message, int status){
        super(message);
        this.status = status;
    }

    public GenericHttpServiceException(String message, Throwable ex){
        super(message, ex);
        this.status = 500;
    }

    public GenericHttpServiceException(String message, int status, Throwable ex){
        super(message, ex);
        this.status = status;
    }
}
