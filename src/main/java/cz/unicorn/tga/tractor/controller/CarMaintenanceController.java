package cz.unicorn.tga.tractor.controller;

import cz.unicorn.tga.tractor.model.dto.StkDetail;
import cz.unicorn.tga.tractor.service.CarMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for all repairs or STKs (MOTs)
 *
 * @author John B.
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CarMaintenanceController {

    @Autowired
    private CarMaintenanceService carMaintenanceService;

    /**
     * Finds all Stk by car
     * @param carId
     * @return
     */
    @RequestMapping(value = "/find-stk/{carId}",method = RequestMethod.GET)
    public List<StkDetail> getStkDetailByCarId(@PathVariable("carId") Long carId) {
        return carMaintenanceService.getStkDetailByCarId(carId);
    }
}




