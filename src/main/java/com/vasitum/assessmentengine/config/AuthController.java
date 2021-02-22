package com.vasitum.assessmentengine.config;

import com.vasitum.assessmentengine.security.JwtAuthenticationResponse;
import com.vasitum.assessmentengine.security.JwtTokenProvider;
import com.vasitum.assessmentengine.security.RegisterUserRequest;
import com.vasitum.assessmentengine.userprofile.model.UserProfile;
import com.vasitum.assessmentengine.userprofile.repository.UserProfileRepository;
import com.vasitum.assessmentengine.userprofile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/token")
    public ResponseEntity<?> authenticateUser(@RequestBody RegisterUserRequest registerUserRequest,
                                              @RequestParam("rpn") String rpn,
                                              @RequestAttribute(value = "token") String clientToken) {

        if(Long.parseLong(registerUserRequest.getRpn())!=Long.parseLong(rpn)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid rpn");
        }
        UserProfile userProfile = userProfileService.create(registerUserRequest,clientToken);
        if(userProfile!=null){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            registerUserRequest.getRpn(),
                            registerUserRequest.getRpn()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to create User");
        }
    }
}
