package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.model.CarDTO;
import cz.unicorn.tga.tractor.model.ClientDTO;

import java.util.List;

public interface ClientManagerService {

    List<ClientDTO> getAllClients();
}
