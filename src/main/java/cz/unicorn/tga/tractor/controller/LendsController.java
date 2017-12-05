package cz.unicorn.tga.tractor.controller;

import cz.unicorn.tga.tractor.model.dto.LendDetail;
import cz.unicorn.tga.tractor.model.dto.LendNewForm;
import cz.unicorn.tga.tractor.service.LendService;
import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = LendsController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class LendsController {

    public static final String BASE_URL = CommonConstants.SLASH + "lends";
    private final LendService lendService;

    @Autowired
    public LendsController(final LendService lendService) {
        this.lendService = lendService;
    }

    /**
     * Get detail of lend by ID.
     */
    @RequestMapping(value = "/{lendId}", method = RequestMethod.GET)
    public LendDetail getLendDetail(@PathVariable("lendId") Long lendId) {

        return lendService.getLendDetailById(lendId);
    }

    /**
     * Returning All Lends
     */
    @RequestMapping(method = RequestMethod.GET)
    public LendDetail[] getAllLends() {

        List<LendDetail> lends = lendService.getAllLends();
        return lends.toArray(new LendDetail[lends.size()]);
    }

    /**
     * All Lends by car id.
     */
    @RequestMapping(value = "/find-by-carid/{carId}", method = RequestMethod.GET)
    public List<LendDetail> getLendDetailByCarId(@PathVariable("carId") Long carId) {
        return lendService.getLendDetailByCarId(carId);
    }

    /**
     * Get All lends from client.
     */
    @RequestMapping(value = "/find-by-client/{clientId}", method = RequestMethod.GET)
    public List<LendDetail> getLendDetailByClientId(@PathVariable("clientId") Long clientId) {
        return lendService.getLendDetailByClientId(clientId);
    }

    //TODO ADD LEND
    @RequestMapping(value = "/add-lend", method = RequestMethod.POST)
    public void addNewLend(@RequestBody final LendNewForm lendNewForm) {
        lendService.createNewLend(lendNewForm);
    }

}
