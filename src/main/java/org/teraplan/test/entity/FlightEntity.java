package org.teraplan.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "flights")
public class FlightEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "departure_station")
    private String departureStation;

    @Column(name = "arrival_station")
    private String arrivalStation;

    @Column(name = "departure_time")
    private String departureTime;

    @Column(name = "arrival_time")
    private String arrivalTime;

    @OneToOne(mappedBy = "flight", cascade = CascadeType.ALL)
    private LegEntity leg;
}
