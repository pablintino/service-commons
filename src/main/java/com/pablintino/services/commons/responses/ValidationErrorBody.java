package com.pablintino.services.commons.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@NoArgsConstructor
public class ValidationErrorBody extends HttpErrorBody {
    private Map<String, String> errors;

    public ValidationErrorBody(HttpErrorBody errorBody){
        this.setErrorMessage(errorBody.getErrorMessage());
        this.setStatus(errorBody.getStatus());
        this.setClassName(errorBody.getClassName());
        this.setPath(errorBody.getPath());
        this.setStackTrace(errorBody.getStackTrace());
        this.setTimestamp(errorBody.getTimestamp());
    }
}
