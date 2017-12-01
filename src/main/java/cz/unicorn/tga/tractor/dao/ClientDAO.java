package cz.unicorn.tga.tractor.dao;


import cz.unicorn.tga.tractor.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client,Long> {

    List<Client> findAll();

}
