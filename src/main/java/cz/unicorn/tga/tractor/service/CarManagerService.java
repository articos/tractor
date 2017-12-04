
package cz.unicorn.tga.tractor.service;

import java.util.List;

import cz.unicorn.tga.tractor.model.dto.CarDTO;
import cz.unicorn.tga.tractor.model.dto.CarFilter;
import cz.unicorn.tga.tractor.model.dto.CarNewForm;
import cz.unicorn.tga.tractor.model.dto.CarUpdate;

/**
 * @author DZCJS9F
 *
 */
public interface CarManagerService {

 	void createNewCar(CarNewForm carNewForm);

	List<CarDTO> getAllCars();

	List<CarDTO> findCarsByFilter(CarFilter filter);

	CarDTO getCarById(Long carId);

	CarDTO updateCarById(CarUpdate carUpdate);

}
