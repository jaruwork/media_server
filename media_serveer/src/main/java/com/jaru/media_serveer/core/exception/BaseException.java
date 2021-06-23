package com.jaru.media_serveer.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException{
    private final HttpStatus statusCode;
    private final String code;
    private final String message;

    public BaseException(HttpStatus statusCode, String code, String message) {
        super(message);
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }

}
