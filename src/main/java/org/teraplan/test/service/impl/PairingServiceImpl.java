package org.teraplan.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teraplan.test.converter.PairingMapper;
import org.teraplan.test.dao.AssignmentDao;
import org.teraplan.test.dao.PairingDao;
import org.teraplan.test.dto.PairingDto;
import org.teraplan.test.entity.AssignmentEntity;
import org.teraplan.test.entity.DutyEntity;
import org.teraplan.test.entity.LegEntity;
import org.teraplan.test.entity.PairingEntity;
import org.teraplan.test.service.PairingService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PairingServiceImpl implements PairingService {

    private final PairingDao dao;
    private final AssignmentDao assignmentDao;

    private final PairingMapper mapper;

    @Override
    public List<PairingDto> findByEmployeeId(Integer employeeId) {
        return assignmentDao.findByEmployeeId(employeeId)
                            .stream()
                            .map(AssignmentEntity::getPairing)
                            .map(mapper::entityToDto)
                            .collect(Collectors.toList());
    }

    @Override
    public List<PairingDto> saveAll(List<PairingDto> pairings) {
        List<PairingEntity> entities = pairings.stream()
                                               .map(this::fillEntity)
                                               .collect(Collectors.toList());
        dao.saveAll(entities);

        return pairings;
    }

    private PairingEntity fillEntity(PairingDto dto) {
        PairingEntity pairing = mapper.dtoToEntity(dto);
        Set<DutyEntity> duties = pairing.getDuties();
        if (duties != null) {
            duties.forEach(d -> fillDuties(pairing, d));
        }

        return pairing;
    }

    private void fillDuties(PairingEntity pairing, DutyEntity duty) {
        duty.setPairing(pairing);
        Set<LegEntity> legs = duty.getLegs();
        if (legs != null) {
            legs.forEach(l -> l.setDuty(duty));
        }
    }
}
