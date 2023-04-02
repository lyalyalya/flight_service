package org.teraplan.test.converter;

import org.mapstruct.Mapper;
import org.teraplan.test.dto.AssignmentDto;
import org.teraplan.test.entity.AssignmentEntity;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, PairingMapper.class})
public interface AssignmentMapper {

    AssignmentEntity dtoToEntity(AssignmentDto dto);

    AssignmentDto entityToDto(AssignmentEntity entity);
}
