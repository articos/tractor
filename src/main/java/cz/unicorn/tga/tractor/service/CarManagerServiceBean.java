/**
 *
 */
package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.CarDAO;
import cz.unicorn.tga.tractor.dao.CarFilterDAO;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.model.dto.CarDTO;
import cz.unicorn.tga.tractor.model.dto.CarFilter;
import cz.unicorn.tga.tractor.model.dto.CarNewForm;
import cz.unicorn.tga.tractor.model.dto.CarUpdate;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import cz.unicorn.tga.tractor.model.enumeration.CarsType;
import cz.unicorn.tga.tractor.util.CoreDateUtil;
import cz.unicorn.tga.tractor.mapper.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;

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
        List listToSort;
        listToSort = dtoMapper.convert(carDAO.findAll());

        Collections.sort(listToSort, Comparator.comparing(CarDTO::getCarState).reversed());
        return listToSort;
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

    @Override
    public List<CarDTO> getAllCarsForStk() {
        List<CarDTO> cars = dtoMapper.convert(carDAO.findAll());
        List<CarDTO> results = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -10);
        Date todayMinusTwoMonths = cal.getTime();


        for (CarDTO car : cars){
            if ( (car.getDateOfLastTechnicalCheck().before(todayMinusTwoMonths)) &&
                    (!car.getCarState().equals(CarState.DISABLED.toString())) &&
                    (!(car.getCarState().equals(CarState.NEW.toString())))  ){
                results.add(car);
            }
        }
        return results;
    }


}
