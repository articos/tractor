package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.CarDAO;
import cz.unicorn.tga.tractor.dao.LendDAO;
import cz.unicorn.tga.tractor.dao.StkDAO;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentabilityService {

    private final StkDAO stkDAO;
    private final LendDAO lendDAO;
    private final CarDAO carDAO;

    @Autowired
    public RentabilityService(StkDAO stkDAO, LendDAO lendDAO, CarDAO carDAO) {
        this.stkDAO = stkDAO;
        this.lendDAO = lendDAO;
        this.carDAO = carDAO;
    }


    public List<Car> findneco () {
        return null;
    }

}
