package org.lesnoy.orderservice.exceptions;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException(String message) {
        super(message);
    }
}
