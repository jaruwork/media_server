package com.jaru.media_serveer.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyExistException extends BaseException{
    private final HttpStatus statusCode;
    private final String message;

    public AlreadyExistException(HttpStatus statusCode, String message){
        super(statusCode, "already_exist", message);
        this.statusCode = statusCode;
        this.message = message;
    }
}
