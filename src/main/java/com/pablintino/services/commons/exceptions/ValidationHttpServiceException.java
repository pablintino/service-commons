package com.pablintino.services.commons.exceptions;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;

public class ValidationHttpServiceException extends GenericHttpServiceException {

    @Getter
    private final Map<String, String> errors;

    public ValidationHttpServiceException(String message){
        super(message, 400);
        this.errors = Collections.emptyMap();
    }

    public ValidationHttpServiceException(String message, Map<String, String> errors){
        super(message, 400);
        this.errors = errors;
    }

    public ValidationHttpServiceException(String message, int status){
        super(message, status);
        this.errors = Collections.emptyMap();
    }

    public ValidationHttpServiceException(String message, int status, Map<String, String> errors){
        super(message, status);
        this.errors = errors;
    }

    public ValidationHttpServiceException(String message, Throwable ex){
        super(message, 400, ex);
        this.errors = Collections.emptyMap();
    }

    public ValidationHttpServiceException(String message, int status, Throwable ex){
        super(message, status, ex);
        this.errors = Collections.emptyMap();
    }

    public ValidationHttpServiceException(String message, int status, Throwable ex, Map<String, String> errors){
        super(message, status, ex);
        this.errors = errors;
    }
}
