package cz.unicorn.tga.tractor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.unicorn.tga.tractor.model.dto.CarUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import cz.unicorn.tga.tractor.model.dto.CarDTO;
import cz.unicorn.tga.tractor.model.dto.CarFilter;
import cz.unicorn.tga.tractor.service.CarManagerService;
import cz.unicorn.tga.tractor.web.CommonConstants;

/**
 * Controller
 *
 * @author John B.
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarListController {
	static final String BASE_URL = CommonConstants.SLASH + "cars";

	private final CarManagerService carService;

	/**
	 * Constructor.
	 */
	@Autowired
	public CarListController(CarManagerService carService) {
		this.carService = carService;
	}


	/**
	 * Get all Cars from DB.
	 *
	 * @return JSON with all cars
	 */
	@RequestMapping(method = RequestMethod.GET)
	public CarDTO[] getAllCars() {
		final List<CarDTO> cars = carService.getAllCars();

		return cars.toArray(new CarDTO[cars.size()]);
	}

	/**
	 * Find car by ID.
	 *
	 * @param carId
	 *
	 * @return JSON with one car
	 */
	@RequestMapping(value = "/find-car/{carId}", method = RequestMethod.GET)
	public CarDTO getCarById(@PathVariable("carId") Long carId) {
		return carService.getCarById(carId);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public CarDTO updateCarById(@RequestBody CarUpdate carUpdate) {
		 return carService.updateCarById(carUpdate);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public CarDTO[] findByFilter( CarFilter carFilter) {

		// final CarFilter filter = new CarFilter(id, type, vin, state, priceFrom, priceTo, acquiredFrom, acquiredTo,
		// lastTechnicalCheckFrom, lastTechnicalCheckTo);
		final List<CarDTO> result = carService.findCarsByFilter(carFilter);

		return result.toArray(new CarDTO[result.size()]);
	}

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
