package cz.unicorn.tga.tractor.controller;


import cz.unicorn.tga.tractor.model.CarDTO;
import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@CrossOrigin(origins = "*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = CarListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {

    public static final String BASE_URL = CommonConstants.SLASH + "something";
/*
    @RequestMapping(method = RequestMethod.GET)
    public CarDTO[] getAllCars() {
        final List<CarDTO> cars = carService.getAllCars();

        return cars.toArray(new CarDTO[cars.size()]);
    }
    */
}
