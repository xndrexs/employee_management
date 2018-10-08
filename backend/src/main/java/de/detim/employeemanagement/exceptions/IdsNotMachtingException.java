package de.detim.employeemanagement.exceptions;

public class IdsNotMachtingException extends RuntimeException{
    public IdsNotMachtingException() {
        super("IDs not matching");
    }
}
