package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairDao extends JpaRepository<Repair,Long> {

}
