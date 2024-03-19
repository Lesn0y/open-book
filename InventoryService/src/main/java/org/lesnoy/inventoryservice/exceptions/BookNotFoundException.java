package org.lesnoy.inventoryservice.exceptions;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(String message) {
        super(message);
    }
}
