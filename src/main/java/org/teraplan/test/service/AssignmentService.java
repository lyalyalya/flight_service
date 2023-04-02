package org.teraplan.test.service;

import org.teraplan.test.dto.AssignmentDto;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDto> saveAll(List<AssignmentDto> assignments);
}
