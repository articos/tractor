package cz.unicorn.tga.tractor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.unicorn.tga.tractor.entity.Car;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarDAO extends JpaRepository<Car,Long> {


    @Query("SELECT c FROM Car c WHERE c.carState not in ( 'DISABLED', 'NEW')" )
    List<Car> findCarsForStk();




}
