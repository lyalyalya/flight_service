package org.teraplan.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.teraplan.test.enums.Gender;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "fleet")
    private String fleet;
}
