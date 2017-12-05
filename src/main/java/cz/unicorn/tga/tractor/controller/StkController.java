package cz.unicorn.tga.tractor.controller;

import cz.unicorn.tga.tractor.service.StkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = CarListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class StkController {

    private final StkService stkService;

    @Autowired
    public StkController(StkService stkService) {
        this.stkService = stkService;
    }

    /**
     *
     */
    //TODO VYPSAT stk s autama a klientama
    @RequestMapping(value = "/stk", method = RequestMethod.GET)
    public List getAllStkAndCar() {
        return stkService.findCarsWithStk();
    }
}
