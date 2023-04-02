package org.teraplan.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@Table(name = "assignments")
public class AssignmentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "employee_id")
    @Fetch(value = FetchMode.SELECT)
    @ManyToOne(cascade = CascadeType.ALL)
    private EmployeeEntity employee;

    @JoinColumn(name = "pairing_id")
    @Fetch(value = FetchMode.SELECT)
    @ManyToOne(cascade = CascadeType.ALL)
    private PairingEntity pairing;

    @Column(name = "rank")
    private String rank;
}
