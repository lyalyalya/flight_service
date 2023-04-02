package org.teraplan.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teraplan.test.converter.EmployeeMapper;
import org.teraplan.test.dao.EmployeeDao;
import org.teraplan.test.dto.EmployeeDto;
import org.teraplan.test.entity.EmployeeEntity;
import org.teraplan.test.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao dao;

    private final EmployeeMapper mapper;

    @Override
    public List<EmployeeDto> saveAll(List<EmployeeDto> employees) {
        List<EmployeeEntity> entities = employees.stream()
                                                 .map(mapper::dtoToEntity)
                                                 .collect(Collectors.toList());
        dao.saveAll(entities);

        return employees;
    }
}
