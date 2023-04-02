package org.teraplan.test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.teraplan.test.entity.FlightEntity;

@Repository
public interface FlightDao extends CrudRepository<FlightEntity, Integer> {
}
