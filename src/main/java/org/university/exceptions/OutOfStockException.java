package org.university.exceptions;

public class OutOfStockException extends RuntimeException{
    public OutOfStockException(String errorMessage) {
        super(errorMessage);
    }

}
