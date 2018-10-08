package de.detim.employeemanagement.helper;

import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
}
