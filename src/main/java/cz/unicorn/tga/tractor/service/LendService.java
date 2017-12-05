package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.LendDAO;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Client;
import cz.unicorn.tga.tractor.entity.Lend;
import cz.unicorn.tga.tractor.mapper.LendMapper;
import cz.unicorn.tga.tractor.model.dto.LendDetail;
import cz.unicorn.tga.tractor.util.NoItemFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LendService {

    private final LendDAO lendDAO;
    private final LendMapper lendMapper;

    @Autowired
    public LendService(final LendDAO lendDAO, final LendMapper lendMapper) {
        this.lendDAO = lendDAO;
        this.lendMapper = lendMapper;
    }

    public LendDetail getLendDetailById(Long lendId) throws NoItemFoundByIdException {

        Lend lend = lendDAO.findOne(lendId);
        if (lend == null) {
            throw new NoItemFoundByIdException();
        }

        return lendMapper.toLendDetail(lend);
    }

    public List<LendDetail> getAllLends() {

        return lendMapper.toListOfLandDetail(lendDAO.findAll());
    }

    public List<LendDetail> getLendDetailByCarId(Long carId) throws NoItemFoundByIdException {
        Car car = new Car();
        car.setId(carId);
        List<Lend> lends = lendDAO.findAllByCar(car);
        return lendMapper.toListOfLandDetail(lends);
    }

    public List<LendDetail> getLendDetailByClientId(Long clientId) throws NoItemFoundByIdException {
        Client client = new Client();
        client.setId(clientId);
        List<Lend> lends = lendDAO.findAllByClient(client);
        return lendMapper.toListOfLandDetail(lends);
    }

}
