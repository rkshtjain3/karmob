package com.vasitum.assessmentengine.client.service.impl;

import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.client.repository.ClientRepository;
import com.vasitum.assessmentengine.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByToken(String token) {
        return clientRepository.findByToken(token);
    }
}
