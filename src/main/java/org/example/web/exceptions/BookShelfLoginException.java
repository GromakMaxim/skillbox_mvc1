package org.example.web.exceptions;

public class BookShelfLoginException extends Exception {
    private String message;

    public BookShelfLoginException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
