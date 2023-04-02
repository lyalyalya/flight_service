package org.teraplan.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teraplan.test.converter.FlightMapper;
import org.teraplan.test.dao.AssignmentDao;
import org.teraplan.test.dao.FlightDao;
import org.teraplan.test.dto.FlightDto;
import org.teraplan.test.entity.AssignmentEntity;
import org.teraplan.test.entity.DutyEntity;
import org.teraplan.test.entity.FlightEntity;
import org.teraplan.test.entity.LegEntity;
import org.teraplan.test.entity.PairingEntity;
import org.teraplan.test.service.FlightService;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightDao dao;
    private final AssignmentDao assignmentDao;

    private final FlightMapper mapper;

    @Override
    public List<FlightDto> findByEmployeeId(Integer employeeId) {
        return assignmentDao.findByEmployeeId(employeeId)
                            .stream()
                            .map(AssignmentEntity::getPairing)
                            .filter(Objects::nonNull)
                            .map(PairingEntity::getDuties)
                            .filter(Objects::nonNull)
                            .flatMap(Collection::stream)
                            .map(DutyEntity::getLegs)
                            .filter(Objects::nonNull)
                            .flatMap(Collection::stream)
                            .map(LegEntity::getFlight)
                            .filter(Objects::nonNull)
                            .map(FlightEntity::getId)
                            .map(dao::findById)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .map(mapper::entityToDto)
                            .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> saveAll(List<FlightDto> flights) {
        List<FlightEntity> entities = flights.stream()
                                             .map(mapper::dtoToEntity)
                                             .collect(Collectors.toList());
        dao.saveAll(entities);

        return flights;
    }
}
