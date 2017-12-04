package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Lend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendDAO extends JpaRepository<Lend, Long> {


}
