package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.entity.Repair;
import cz.unicorn.tga.tractor.model.repair.RepairDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface RepairMapper {

    @Mapping(target = "id", source = "repair.id")
    @Mapping(target = "carId", source = "car.id")
    @Mapping(target = "repairResolution", source = "repair.repairResolution")
    @Mapping(target = "price", source = "repair.price")
    RepairDetail toRepairDetail(final Repair repair);

    //TODO musim napsat testy moje mapovani listu
//    List<RepairDetail> toRepairs(List<Repair> repair);

}