/**
 *
 */
package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.CarDAO;
import cz.unicorn.tga.tractor.dao.CarFilterDAO;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.CarDTO;
import cz.unicorn.tga.tractor.model.CarFilter;
import cz.unicorn.tga.tractor.model.CarNewForm;
import cz.unicorn.tga.tractor.model.CarUpdate;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import cz.unicorn.tga.tractor.model.enumeration.CarsType;
import cz.unicorn.tga.tractor.util.CoreDateUtil;
import cz.unicorn.tga.tractor.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author DZCJS9F
 */
@Service
@Transactional
public class CarManagerServiceBean implements CarManagerService {

    private final CarDAO carDAO;
    private final CarFilterDAO carFilterDAO;
    private final DTOMapper dtoMapper;

    @Autowired
    public CarManagerServiceBean(CarDAO carDAO, CarFilterDAO carFilterDAO, DTOMapper dtoMapper) {
        this.carDAO = carDAO;
        this.carFilterDAO = carFilterDAO;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public void createNewCar(final CarNewForm carNewForm) {

        final Car car = createGeneralCar();

        // set parametrs from dto
        try {
            setFieldFromDto(carNewForm, car);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        save(car);
    }

    /**
     * Check CarNewForm for null values, if not set values to Car
     * CarState is always NEW.
     * DateOfLastTechnicalCheck and setDateOfAcquisition are set to today.
     * @param carNewForm
     * @param car
     * @throws ParseException
     */
    private void setFieldFromDto(final CarNewForm carNewForm, final Car car) throws ParseException {


        //TODO null validace + null validation

        Date date = new Date();
        if ( (carNewForm.getPrice() == null) || (carNewForm.getVin()==null) ){
            return;
        } else {
            car.setType(CarsType.valueOf(carNewForm.getType()));
            car.setVin(carNewForm.getVin());
        }
        car.setType(CarsType.valueOf(carNewForm.getType()));
        car.setDateOfLastTechnicalCheck(date);
        car.setDateOfAcquisition(date);
        if(carNewForm==null) {
            car.setDateOfLastTechnicalCheck(date);
        }
        car.setCarState(CarState.NEW);
    }

    /**
     *
     * @param car
     */
    private void save(final Car car) {
        carDAO.save(car);
    }

    /**
     *
     */
    private Car createGeneralCar() {
        final Car car = new Car();
        car.setCarState(CarState.defaultState());
        car.setDateOfAcquisition(CoreDateUtil.getNow());

        return car;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CarDTO> getAllCars() {

        return dtoMapper.convert(carDAO.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CarDTO> findCarsByFilter(final CarFilter filter) {

        return dtoMapper.convert(carFilterDAO.findByFilter(filter));
    }


    @Override
    public CarDTO getCarById(Long carId) {

        return dtoMapper.convert(carDAO.findOne(carId));
    }


    @Override
    public CarDTO updateCarById(CarUpdate carUpdate) {
        Car carFromDB = carDAO.findOne(carUpdate.getId());

        dtoMapper.setValueFromForm(carUpdate, carFromDB);


        //TODO mapper na CarDTO z CAR, muze se dodelat z metody setfield
        Car save = carDAO.save(carFromDB);
        return null;
    }


}
