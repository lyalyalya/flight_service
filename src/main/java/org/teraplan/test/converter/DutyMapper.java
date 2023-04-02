package org.teraplan.test.converter;

import org.mapstruct.Mapper;
import org.teraplan.test.dto.DutyDto;
import org.teraplan.test.entity.DutyEntity;

@Mapper(componentModel = "spring", uses = {LegMapper.class, PairingMapper.class})
public interface DutyMapper {

    DutyEntity dtoToEntity(DutyDto dto);

    DutyDto entityToDto(DutyEntity entity);
}
