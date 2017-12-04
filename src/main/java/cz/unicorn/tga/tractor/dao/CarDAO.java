package cz.unicorn.tga.tractor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.unicorn.tga.tractor.entity.Car;

import java.util.List;


public interface CarDAO extends JpaRepository<Car,Long> {


}
