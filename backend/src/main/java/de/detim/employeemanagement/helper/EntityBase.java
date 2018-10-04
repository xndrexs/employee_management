package de.detim.employeemanagement.helper;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
