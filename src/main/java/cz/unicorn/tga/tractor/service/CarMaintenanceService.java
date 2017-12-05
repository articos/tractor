package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.StkDAO;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.mapper.StkMapper;
import cz.unicorn.tga.tractor.model.dto.StkDetail;
import cz.unicorn.tga.tractor.util.NoItemFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarMaintenanceService {

    private final StkDAO stkDao;
    private final StkMapper stkMapper;

    @Autowired
    public CarMaintenanceService(final StkDAO stkDao, final StkMapper stkMapper) {
        this.stkDao = stkDao;
        this.stkMapper = stkMapper;
    }

    public StkDetail getRepairDetailById(Long stkId) throws NoItemFoundByIdException {

        Stk stk = stkDao.findOne(stkId);
        if (stkId == null) {
            throw new NoItemFoundByIdException();
        }

        return stkMapper.toStkDetail(stk);
    }

    public List<StkDetail> getStkDetailByCarId(Long carId) throws NoItemFoundByIdException {
        Car car = new Car();
        car.setId(carId);
        List<Stk> stklist = stkDao.findAllByCar(car);
        return stkMapper.toStkDetails(stklist);
    }

}

