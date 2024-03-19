package org.lesnoy.bookservice.exceptions;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(String message) {
        super(message);
    }
}
