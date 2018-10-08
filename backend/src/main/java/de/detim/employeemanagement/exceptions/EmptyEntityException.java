package de.detim.employeemanagement.exceptions;

public class EmptyEntityException extends RuntimeException {
    public EmptyEntityException(){
        super("Entity must not be empty");
    }
}
