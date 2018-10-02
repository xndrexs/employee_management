package de.detim.employeemanagement.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class ModelBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
