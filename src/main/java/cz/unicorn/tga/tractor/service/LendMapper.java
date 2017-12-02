package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.entity.Lend;
import cz.unicorn.tga.tractor.model.lend.LendDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LendMapper {

    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "vin", source = "car.vin")
    @Mapping(target = "carId", source = "car.id")
    LendDetail toLendDetail(final Lend lend);
}
