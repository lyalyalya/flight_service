package org.teraplan.test.converter;

import org.mapstruct.Mapper;
import org.teraplan.test.dto.EmployeeDto;
import org.teraplan.test.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeEntity dtoToEntity(EmployeeDto dto);

    EmployeeDto entityToDto(EmployeeEntity entity);
}
