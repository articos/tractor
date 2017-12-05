package cz.unicorn.tga.tractor.dao;

import java.util.List;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.dto.CarFilter;

public interface CarFilterDAO extends GenericDAO<Car,Long> {

	List<Car> findByFilter(final CarFilter filter);
}
