package cz.unicorn.tga.tractor.controller;

import cz.unicorn.tga.tractor.model.dto.RepairDetail;
import cz.unicorn.tga.tractor.service.RepairService;
import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for repair operations.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = RepairDetailController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RepairDetailController {

    static final String BASE_URL = CommonConstants.SLASH + "repair-detail";

    @Autowired
    private RepairService repairService;

    /**
     * Find detail of repair by ID of repair.
     */
    @RequestMapping(value = "/{repairId}", method = RequestMethod.GET)
    public RepairDetail getRepairDetail(@PathVariable("repairId") Long repairDetailId) {
        return repairService.getRepairDetailById(repairDetailId);
    }

    /**
     * Find repair details from each cars.
     */
    @RequestMapping(value = "/find-repairs/{carId}", method = RequestMethod.GET)
    public List<RepairDetail> getRepairDetailByCarId(@PathVariable("carId") Long carId) {
        return repairService.getRepairDetailByCarId(carId);
    }
}
