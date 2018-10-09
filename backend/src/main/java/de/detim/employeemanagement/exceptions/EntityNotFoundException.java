package de.detim.employeemanagement.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(){
        super("ID not found");
    }
}
