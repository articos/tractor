package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.RepairDao;
import cz.unicorn.tga.tractor.entity.Repair;
import cz.unicorn.tga.tractor.model.repair.RepairDetail;
import cz.unicorn.tga.tractor.util.NoItemFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepairService {

    private final RepairDao repairDao;
    private final RepairMapper repairMapper;

    @Autowired
    public RepairService(final RepairDao repairDao, final RepairMapper repairMapper) {
        this.repairDao = repairDao;
        this.repairMapper = repairMapper;
    }

    public RepairDetail getRepairDetailById(Long repairId) throws NoItemFoundByIdException {

        Repair repair = repairDao.findOne(repairId);
        if (repair == null) {
            throw new NoItemFoundByIdException();
        }

        return repairMapper.toRepairDetail(repair);
    }
}
