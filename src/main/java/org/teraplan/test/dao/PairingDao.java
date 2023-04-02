package org.teraplan.test.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.teraplan.test.entity.PairingEntity;

@Repository
public interface PairingDao extends CrudRepository<PairingEntity, Integer> {

}
