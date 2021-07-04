package com.jaru.media_serveer.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotExistDirectoryException extends BaseException{
    private final HttpStatus statusCode;
    private final String message;

    public NotExistDirectoryException(HttpStatus statusCode, String message) {
        super(statusCode, "not_exist_dir", message);
        this.statusCode = statusCode;
        this.message = message;
    }
}
