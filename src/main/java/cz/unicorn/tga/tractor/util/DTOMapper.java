package cz.unicorn.tga.tractor.util;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Client;
import cz.unicorn.tga.tractor.model.ClientDTO;
import org.mapstruct.Mapper;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.CarDTO;
import org.mapstruct.Mapping;

@Mapper
public interface DTOMapper {


	// TODO ZEPTAT SE JAK SE PREMAPUJE CARSTYPE KDYZ JE TO JINEJ DATOVEJ TYP
	@Mapping(target = "type", expression = "java(car.getCarState().toString())")
	CarDTO convert(final Car car);

	List<CarDTO> convert(final List<Car> cars);

	List<ClientDTO> convertClients(final List<Client> clients);
}

//
//	private Long id;
//	private CarsType type;
//	private String vin;
//	private CarState carState;
//	private Date dateOfAcquisition;
//	private Date dateOfLastTechnicalCheck;
//	private BigDecimal price;
//
//	private Long id;
//	private String type;
//	private String vin;
//	private String carState;
//	private Date dateOfAcquisition;
//	private Date dateOfLastTechnicalCheck;
//	private BigDecimal price;
