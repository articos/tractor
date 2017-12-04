package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Repair;
import cz.unicorn.tga.tractor.model.repair.RepairDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairDAO extends JpaRepository<Repair,Long> {

    List<Repair> findAllByCar(Car car);
}
