/**
 *
 */
package cz.unicorn.tga.tractor.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.unicorn.tga.tractor.dao.*;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.*;
import cz.unicorn.tga.tractor.model.enumeration.*;
import cz.unicorn.tga.tractor.util.*;

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
     * @param carNewForm
     * @param car
     * @throws ParseException
     */
    private void setFieldFromDto(final CarNewForm carNewForm, final Car car) throws ParseException {

        Date date = new Date();


        //TODO dobra validace a mozna nezapisuje setDateOfLastTechnicalCheck
        if ((carNewForm.getPrice() == null)){
            return;
        }

        car.setPrice(carNewForm.getPrice());
        car.setType(CarsType.valueOf(carNewForm.getType()));
        car.setVin(carNewForm.getVin());
        car.setDateOfAcquisition(new SimpleDateFormat("yyyy.MM.dd").parse(carNewForm.getDateOfAcquisition().toString()));
        car.setDateOfLastTechnicalCheck(new SimpleDateFormat("yyyy.MM.dd").parse(carNewForm.getDateOfAcquisition().toString()));
    }

    /**
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


}
