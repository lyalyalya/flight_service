package org.teraplan.test.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.teraplan.test.dto.PairingDto;
import org.teraplan.test.entity.PairingEntity;

@Mapper(componentModel = "spring", uses = DutyMapper.class)
public interface PairingMapper {

    PairingEntity dtoToEntity(PairingDto dto);

    PairingDto entityToDto(PairingEntity entity);
}
