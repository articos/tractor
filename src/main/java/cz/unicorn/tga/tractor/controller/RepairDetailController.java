package cz.unicorn.tga.tractor.controller;

import cz.unicorn.tga.tractor.model.repair.RepairDetail;
import cz.unicorn.tga.tractor.service.RepairService;
import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = RepairDetailController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RepairDetailController {

    static final String BASE_URL = CommonConstants.SLASH + "repair-detail";

    @Autowired
    private RepairService repairService;

    /**
     * find Detail of Repair By Id of repair
     * @param repairDetailId
     * @return JSON with one RepairDetail
     */
    @RequestMapping(value ="/{repairId}", method = RequestMethod.GET)
    public RepairDetail getRepairDetail(@PathVariable("repairId") Long repairDetailId) {
        return repairService.getRepairDetailById(repairDetailId);
    }
}
