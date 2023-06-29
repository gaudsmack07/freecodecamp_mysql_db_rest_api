package com.dundermiflin.office.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(Integer pageNum, Integer size, String sortBy) {
        Page<Client> page = clientRepository.findAll(PageRequest.of(pageNum, size, Sort.by(sortBy).descending()));
        return page.getContent();
    }

    public List<Client> getClientByName(String name) {
        return clientRepository.findByName(name);
    }
}
