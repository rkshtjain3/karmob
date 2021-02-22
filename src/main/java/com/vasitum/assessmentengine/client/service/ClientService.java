package com.vasitum.assessmentengine.client.service;


import com.vasitum.assessmentengine.client.model.Client;

public interface ClientService {
    Client findByToken(String token);
}
