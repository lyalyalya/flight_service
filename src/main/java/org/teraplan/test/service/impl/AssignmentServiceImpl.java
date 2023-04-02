package org.teraplan.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teraplan.test.converter.AssignmentMapper;
import org.teraplan.test.dao.AssignmentDao;
import org.teraplan.test.dao.EmployeeDao;
import org.teraplan.test.dao.PairingDao;
import org.teraplan.test.dto.AssignmentDto;
import org.teraplan.test.entity.AssignmentEntity;
import org.teraplan.test.service.AssignmentService;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentDao dao;
    private final PairingDao pairingDao;
    private final EmployeeDao employeeDao;
    private final AssignmentMapper mapper;

    @Override
    public List<AssignmentDto> saveAll(List<AssignmentDto> assignments) {
        List<AssignmentEntity> entities = assignments.stream()
                                                     .map(this::fillEntity)
                                                     .collect(Collectors.toList());
        dao.saveAll(entities);
        return assignments;
    }

    private AssignmentEntity fillEntity(AssignmentDto dto) {
        AssignmentEntity entity = mapper.dtoToEntity(dto);

        addIfPresent(dto::getEmployeeId, entity::setEmployee).accept(employeeDao);
        addIfPresent(dto::getPairingId, entity::setPairing).accept(pairingDao);

        return entity;
    }

    private <E> Consumer<CrudRepository<E, Integer>> addIfPresent(Supplier<Integer> idSupplier, Consumer<E> action) {
        return dao -> {
            Integer id = idSupplier.get();
            if (id != null) {
                Optional<E> pairing = dao.findById(id);
                pairing.ifPresent(action);
            }
        };
    }
}
