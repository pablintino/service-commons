package com.pablintino.services.commons.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class HttpErrorBody {
    private int status;
    private String errorMessage;

    @ToString.Exclude
    private String stackTrace;
    private String className;
    private long timestamp;
    private String path;
}
