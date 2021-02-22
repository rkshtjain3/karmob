package com.vasitum.assessmentengine.client.controller;

import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.client.payload.ClientCreatePayload;
import com.vasitum.assessmentengine.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("v1/client")
    public ResponseEntity<?> create(@Validated @RequestBody ClientCreatePayload createPayload) {
        Client client = new Client()
                .setEmail(createPayload.getEmail())
                .setFullName(createPayload.getFullName())
                .setLocation(createPayload.getLocation())
                .setMobile(createPayload.getMobile())
                .setPaid(true)
                .setStatus(createPayload.getStatus())
                .setToken(getToken());
        client = clientRepository.save(client);
        return ResponseEntity.ok().body(client);
    }

    private String getToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
