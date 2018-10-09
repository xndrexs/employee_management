package de.detim.employeemanagement.exceptions;

public class IdsNotMachtingException extends RuntimeException{
    public IdsNotMachtingException(Long id1, Long id2) {
        super("IDs not matching: " + id1.toString() + " != " + id2.toString());
    }
}
