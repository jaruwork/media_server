package com.jaru.media_serveer.core.exception;

public class MediaServerException extends RuntimeException{
    public MediaServerException(String message) { super(message); }

    public MediaServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
