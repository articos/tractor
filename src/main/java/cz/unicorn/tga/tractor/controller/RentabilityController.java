package cz.unicorn.tga.tractor.controller;

import cz.unicorn.tga.tractor.service.RentabilityService;
import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for rentability math
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RentabilityController {

    private RentabilityService rentabilityService;

    @Autowired
    public RentabilityController(final RentabilityService rentabilityService) {
        this.rentabilityService = rentabilityService;
    }

    @RequestMapping(value = "/rentability", method = RequestMethod.GET)
    public List<Object> gerRentabilities() {
        return null;
    }

}
