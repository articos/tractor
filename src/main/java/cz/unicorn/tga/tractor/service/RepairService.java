package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.RepairDAO;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Repair;
import cz.unicorn.tga.tractor.model.repair.RepairDetail;
import cz.unicorn.tga.tractor.util.NoItemFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepairService {

    private final RepairDAO repairDAO;
    private final RepairMapper repairMapper;

    @Autowired
    public RepairService(final RepairDAO repairDAO, final RepairMapper repairMapper) {
        this.repairDAO = repairDAO;
        this.repairMapper = repairMapper;
    }

    public RepairDetail getRepairDetailById(Long repairId) throws NoItemFoundByIdException {

        Repair repair = repairDAO.findOne(repairId);
        if (repair == null) {
            throw new NoItemFoundByIdException();
        }

        return repairMapper.toRepairDetail(repair);
    }

    //TODO dodelat vyhledavani podle id auta
    public List<RepairDetail> getRepairDetailByCarId(Long carId) throws NoItemFoundByIdException {
        Car car = new Car();
        car.setId(carId);
        List<Repair> repairs = repairDAO.findAllByCar(car);
        return repairMapper.convertToListOfRepairDetail(repairs);
        //  return null;
    }
}
