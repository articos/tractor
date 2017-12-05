package cz.unicorn.tga.tractor.mapper;

import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.dto.StkDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface StkMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "checkDate", source = "checkDate")
    @Mapping(target = "passed", source = "passed")

    StkDetail toStkDetail(final Stk stk);
    List<StkDetail> toStkDetails(List<Stk> stk);
}