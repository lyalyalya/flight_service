package org.teraplan.test.service;

import org.teraplan.test.dto.FlightDto;

import java.util.List;

public interface FlightService {

    List<FlightDto> findByEmployeeId(Integer employeeId);

    List<FlightDto> saveAll(List<FlightDto> flights);
}
