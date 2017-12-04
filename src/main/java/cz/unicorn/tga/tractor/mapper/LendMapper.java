package cz.unicorn.tga.tractor.mapper;

import cz.unicorn.tga.tractor.entity.Lend;
import cz.unicorn.tga.tractor.model.dto.LendDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface LendMapper {

    @Mapping(target = "clientName", source = "client.name")
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "vin", source = "car.vin")
    @Mapping(target = "carId", source = "car.id")
    LendDetail toLendDetail(final Lend lend);

    List<LendDetail> toListOfLandDetail(final List<Lend> lend);
}
