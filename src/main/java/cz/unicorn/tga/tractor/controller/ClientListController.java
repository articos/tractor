package cz.unicorn.tga.tractor.controller;


import cz.unicorn.tga.tractor.model.dto.ClientDTO;
import cz.unicorn.tga.tractor.service.ClientManagerService;
import cz.unicorn.tga.tractor.web.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller for Clients
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = ClientListController.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientListController {

    public static final String BASE_URL = CommonConstants.SLASH + "clients";

    @Autowired
    private ClientManagerService clientService;

    /**
     * Get all clients.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ClientDTO[] getAllClients() {
        final List<ClientDTO> clients = clientService.getAllClients();

        return clients.toArray(new ClientDTO[clients.size()]);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ClientDTO[] getClientsByNameContains(@RequestBody String word) {

        if (word.trim().length() < 3) {
            throw new IllegalArgumentException("Vyhledavany kus slova musi mit tri a vice pismen");
        }

        final List<ClientDTO> clients = clientService.getClientsByNameContains(word);
        return clients.toArray(new ClientDTO[clients.size()]);
    }
}
