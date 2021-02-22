package com.vasitum.assessmentengine.userprofile.controller;

import com.vasitum.assessmentengine.client.model.Client;
import com.vasitum.assessmentengine.client.service.ClientService;
import com.vasitum.assessmentengine.userprofile.model.UserProfile;
import com.vasitum.assessmentengine.userprofile.payload.UserProfilePayload;
import com.vasitum.assessmentengine.userprofile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    ClientService clientService;

    @Autowired
    UserProfileRepository userProfileRepository;

    @PostMapping("v1/user")
    public ResponseEntity<?> create(@Validated @RequestBody UserProfilePayload userPayload) {
        Client client = clientService.findByToken(userPayload.getToken());
        if (client != null) {
            UserProfile userProfile = new UserProfile()
                    .setFullName(userPayload.getName())
                    .setRpn(userPayload.getRpn())
                    .setDob(userPayload.getDob())
                    .setRole(userPayload.getRole())
                    .setClient(client);
            userProfile = userProfileRepository.save(userProfile);
            return ResponseEntity.ok().body(userProfile);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client Not Found");
    }

    /*@GetMapping("token")
    public String create() {
        return "Success";
    }
*/
}
