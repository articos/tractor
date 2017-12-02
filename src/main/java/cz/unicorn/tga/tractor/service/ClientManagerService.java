package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.model.CarDTO;
import cz.unicorn.tga.tractor.model.ClientDTO;

import java.util.List;

public interface ClientManagerService {

    /**
     * Get All Clients from ClientDAO
     * @return List Of ClientDTO
     */
    List<ClientDTO> getAllClients();

    /**
     * Delete Client by provided ID
     * @param clientId
     */
    void deleteClientById(Long clientId);
}
