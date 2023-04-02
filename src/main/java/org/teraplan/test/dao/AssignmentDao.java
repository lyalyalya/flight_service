package org.teraplan.test.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.teraplan.test.entity.AssignmentEntity;

import java.util.List;

@Repository
public interface AssignmentDao extends CrudRepository<AssignmentEntity, Integer> {

    @Query("SELECT a FROM AssignmentEntity a JOIN a.employee e WHERE e.id = :employeeId")
    List<AssignmentEntity> findByEmployeeId(@Param("employeeId") Integer employeeId);
}
