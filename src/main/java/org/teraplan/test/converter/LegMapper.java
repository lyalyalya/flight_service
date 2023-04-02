package org.teraplan.test.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.teraplan.test.dao.FlightDao;
import org.teraplan.test.dto.LegDto;
import org.teraplan.test.entity.LegEntity;

@Mapper(componentModel = "spring", uses = LegMapper.class)
public abstract class LegMapper {

    @Autowired
    protected FlightDao flightDao;

    @Mapping(target = "flight", expression = "java(flightDao.findById(dto.getFlightId()).get())")
    public abstract LegEntity dtoToEntity(LegDto dto);

    @Mapping(source = "flight.id", target = "flightId")
    public abstract LegDto entityToDto(LegEntity entity);
}
