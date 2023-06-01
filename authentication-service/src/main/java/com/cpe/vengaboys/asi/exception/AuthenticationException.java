package com.cpe.vengaboys.asi.exception;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("Authentication failed");
    }
}
