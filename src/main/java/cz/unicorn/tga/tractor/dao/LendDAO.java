package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Client;
import cz.unicorn.tga.tractor.entity.Lend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendDAO extends JpaRepository<Lend, Long> {

    List<Lend> findAllByCar(Car car);

    List<Lend> findAllByClient(Client client);
}
