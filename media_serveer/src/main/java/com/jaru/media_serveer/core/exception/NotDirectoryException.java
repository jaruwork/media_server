package com.jaru.media_serveer.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotDirectoryException extends BaseException{
    private final HttpStatus statusCode;
    private final String message;

    public NotDirectoryException(HttpStatus statusCode, String message) {
        super(statusCode, "not_dir", message);
        this.statusCode = statusCode;
        this.message = message;
    }
}