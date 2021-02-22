package com.vasitum.assessmentengine.userprofile.service.impl;

import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.client.repository.ClientRepository;
import com.vasitum.assessmentengine.security.RegisterUserRequest;
import com.vasitum.assessmentengine.userprofile.model.UserProfile;
import com.vasitum.assessmentengine.userprofile.repository.UserProfileRepository;
import com.vasitum.assessmentengine.userprofile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile create(RegisterUserRequest userRequest, String clientToken) {
        Client client = clientRepository.findByToken(clientToken);
        UserProfile userProfile = new UserProfile()
                .setClient(client)
                .setDob(userRequest.getDob())
                .setRole("candidate")
                .setFullName(userRequest.getName())
                .setRpn(Long.parseLong(userRequest.getRpn()));
        return userProfileRepository.save(userProfile);
    }
}
