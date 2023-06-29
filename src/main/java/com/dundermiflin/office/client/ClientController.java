package com.dundermiflin.office.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/clients")
    public List<Client> getAllClients(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size, @RequestParam(required = false) String sortBy){
        return clientService.getAllClients(page, size, sortBy);
    }

    @RequestMapping("/clients/{name}")
    public List<Client> getClientByName(@PathVariable String name){
        return clientService.getClientByName(name);
    }
}
