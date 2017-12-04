package cz.unicorn.tga.tractor.mapper;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Client;
import cz.unicorn.tga.tractor.model.dto.CarUpdate;
import cz.unicorn.tga.tractor.model.dto.ClientDTO;
import org.mapstruct.Mapper;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.dto.CarDTO;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface DTOMapper {

	CarDTO convert(final Car car);

	Car convert(final CarDTO car);

	List<CarDTO> convert(final List<Car> cars);

	List<ClientDTO> convertClients(final List<Client> clients);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vin", ignore = true)
	void setValueFromForm(CarUpdate carUpdate, @MappingTarget Car carFromDB);
}

