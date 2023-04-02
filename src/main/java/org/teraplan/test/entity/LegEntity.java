package org.teraplan.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "legs")
public class LegEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="duty_id")
    private DutyEntity duty;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;
}
