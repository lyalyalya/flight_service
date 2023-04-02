package org.teraplan.test.service;

import org.teraplan.test.dto.AssignmentDto;
import org.teraplan.test.entity.AssignmentEntity;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDto> saveAll(List<AssignmentDto> assignments);

    List<AssignmentEntity> findByEmployeeId(Integer employeeId);
}
