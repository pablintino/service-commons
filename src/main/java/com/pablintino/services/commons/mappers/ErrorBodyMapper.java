package com.pablintino.services.commons.mappers;

import com.pablintino.services.commons.exceptions.GenericHttpServiceException;
import com.pablintino.services.commons.exceptions.ValidationHttpServiceException;
import com.pablintino.services.commons.responses.HttpErrorBody;
import com.pablintino.services.commons.responses.ValidationErrorBody;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Map;


public class ErrorBodyMapper {

    private final boolean debugMode;

    public ErrorBodyMapper(){
        this.debugMode = false;
    }

    public ErrorBodyMapper(boolean debugMode){
        this.debugMode = debugMode;
    }

    public HttpErrorBody mapFromException(GenericHttpServiceException exception, HttpServletRequest request){
        HttpErrorBody body = mapFromException(exception);
        body.setStatus(exception.getStatus());
        body.setPath(request.getRequestURI());
        return body;
    }

    public HttpErrorBody mapFromException(Exception exception, HttpServletRequest request, int status){
        HttpErrorBody body = mapFromException(exception);
        body.setPath(request.getRequestURI());
        body.setStatus(status);
        return body;
    }

    public HttpErrorBody mapFromException(Exception exception){
        HttpErrorBody body = new HttpErrorBody();
        body.setErrorMessage(ExceptionUtils.getRootCause(exception).getMessage());
        body.setTimestamp(Instant.now().getEpochSecond());
        if(debugMode){
            body.setStackTrace(ExceptionUtils.getStackTrace(exception));
            if(exception.getStackTrace() != null && exception.getStackTrace().length > 0){
                body.setClassName(exception.getStackTrace()[0].getClassName());
            }
        }
        return body;
    }

    public ValidationErrorBody mapFromValidationException(Exception exception, HttpServletRequest request, int status,  Map<String, String> fieldErrors){
        ValidationErrorBody body = new ValidationErrorBody(mapFromException(exception, request, status));
        body.setErrors(fieldErrors);
        return body;
    }


    public ValidationErrorBody mapFromValidationException(Exception exception, Map<String, String> fieldErrors){
        ValidationErrorBody body = new ValidationErrorBody(mapFromException(exception));
        body.setErrors(fieldErrors);
        return body;
    }

    public ValidationErrorBody mapFromValidationException(ValidationHttpServiceException exception, HttpServletRequest request){
        ValidationErrorBody body = new ValidationErrorBody(mapFromException(exception, request));
        body.setErrors(exception.getErrors());
        return body;
    }
}
