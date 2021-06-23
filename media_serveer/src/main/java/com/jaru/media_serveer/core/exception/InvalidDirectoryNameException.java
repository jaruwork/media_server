package com.jaru.media_serveer.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidDirectoryNameException extends BaseException {
    private final HttpStatus statusCode;
    private final String message;

    public InvalidDirectoryNameException(HttpStatus statusCode, String message) {
        super(statusCode, "failed_dir_rename", message);
        this.statusCode = statusCode;
        this.message = message;
    }
}
