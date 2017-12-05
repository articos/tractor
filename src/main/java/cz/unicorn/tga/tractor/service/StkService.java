package cz.unicorn.tga.tractor.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.unicorn.tga.tractor.dao.CarDAO;
import cz.unicorn.tga.tractor.dao.LendDAO;
import cz.unicorn.tga.tractor.dao.StkDAO;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.dto.CarForStkDTO;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class StkService {

    private final StkDAO stkDAO;
    private final LendDAO lendDAO;
    private final CarDAO carDAO;

    @Autowired
    public StkService(StkDAO stkDAO, LendDAO lendDAO, CarDAO carDAO) {
        this.stkDAO = stkDAO;
        this.lendDAO = lendDAO;
        this.carDAO = carDAO;
    }


    public List findCarsWithStk () {


        List<Car> listOfCars = carDAO.findCarsForStk();
        List<Long> carIds = new ArrayList<>();
        for (Car car : listOfCars) {
            carIds.add(car.getId());
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)-1);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+2);

        List<Object[]> list = stkDAO.findAllStkByCar(
                Arrays.asList(new CarState[]{CarState.DISABLED, CarState.NEW}),
                cal.getTime()
        );

        return list;
    }

}
