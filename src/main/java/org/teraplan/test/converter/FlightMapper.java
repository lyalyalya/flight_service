package org.teraplan.test.converter;

import org.mapstruct.Mapper;
import org.teraplan.test.dto.FlightDto;
import org.teraplan.test.entity.FlightEntity;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    FlightEntity dtoToEntity(FlightDto dto);

    FlightDto entityToDto(FlightEntity entity);
}
