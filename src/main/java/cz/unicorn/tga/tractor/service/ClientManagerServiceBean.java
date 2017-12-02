package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.ClientDAO;
import cz.unicorn.tga.tractor.model.ClientDTO;
import cz.unicorn.tga.tractor.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientManagerServiceBean implements ClientManagerService {

    private final ClientDAO clientDAO;
    private final DTOMapper dtoMapper;

    @Autowired
    public ClientManagerServiceBean(ClientDAO clientDAO, DTOMapper dtoMapper) {
        this.clientDAO = clientDAO;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return dtoMapper.convertClients(clientDAO.findAll());
    }

    @Override
    public void deleteClientById(Long clientId) {
        clientDAO.delete(clientId);
    }

}
