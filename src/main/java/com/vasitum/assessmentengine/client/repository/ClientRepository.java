package com.vasitum.assessmentengine.client.repository;

import com.vasitum.assessmentengine.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByToken(String token);
}
