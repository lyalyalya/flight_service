package org.teraplan.test.service;

import org.teraplan.test.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> saveAll(List<EmployeeDto> dto);
}
