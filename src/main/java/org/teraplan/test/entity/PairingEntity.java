package org.teraplan.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pairings")
public class PairingEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fleet")
    private String fleet;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @OneToMany(mappedBy = "pairing", cascade = CascadeType.ALL)
    private Set<DutyEntity> duties;
}
