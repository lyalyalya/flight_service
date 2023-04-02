package org.teraplan.test.service;

import org.teraplan.test.dto.PairingDto;

import java.util.List;

public interface PairingService {

    List<PairingDto> findByEmployeeId(Integer employeeId);

    List<PairingDto> saveAll(List<PairingDto> pairings);
}
