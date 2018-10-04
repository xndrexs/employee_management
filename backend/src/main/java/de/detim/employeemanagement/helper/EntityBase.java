package de.detim.employeemanagement.helper;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
