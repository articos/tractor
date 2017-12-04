package cz.unicorn.tga.tractor.controller;


import cz.unicorn.tga.tractor.model.dto.ClientDTO;
import cz.unicorn.tga.tractor.service.ClientManagerService;
import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = ClientListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientListController {

    public static final String BASE_URL = CommonConstants.SLASH + "clients";

    @Autowired
    private ClientManagerService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ClientDTO[] getAllClients() {
        final List<ClientDTO> clients = clientService.getAllClients();

        return clients.toArray(new ClientDTO[clients.size()]);
    }


    /* TODO MAZAT KLIENTA CONSTRAINT PROBLEM
    /*
    @RequestMapping(value = "/client-delete/{clientId}", method = RequestMethod.DELETE)
    public void deleteCarById(@PathVariable("clientId") Long clientId) {
        clientService.deleteClientById(clientId);
    }
*/


}
