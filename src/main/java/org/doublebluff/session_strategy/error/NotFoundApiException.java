package org.doublebluff.session_strategy.error;

public class NotFoundApiException extends ApiException {

    public NotFoundApiException() {
        this("");
    }

    public NotFoundApiException(String message) {
        super(message);
    }
}
