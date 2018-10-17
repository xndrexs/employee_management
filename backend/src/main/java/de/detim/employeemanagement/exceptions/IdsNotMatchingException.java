package de.detim.employeemanagement.exceptions;

public class IdsNotMatchingException extends RuntimeException{
    public IdsNotMatchingException(Long objectId, Long urlId) {
        super("IDs not matching: " + objectId.toString() + " != " + urlId.toString());
    }
}
