package org.example;

public class EmployeeAlreadyAddedException  extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}

