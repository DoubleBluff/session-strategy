package org.doublebluff.session_strategy.error;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
