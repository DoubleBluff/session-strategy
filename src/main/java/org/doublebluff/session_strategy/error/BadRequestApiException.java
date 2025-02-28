package org.doublebluff.session_strategy.error;

public class BadRequestApiException extends ApiException {

    public BadRequestApiException(String message) {
        super(message);
    }
}
