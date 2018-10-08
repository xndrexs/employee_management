package de.detim.employeemanagement.exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(){
        super("ID not found");
    }
}
