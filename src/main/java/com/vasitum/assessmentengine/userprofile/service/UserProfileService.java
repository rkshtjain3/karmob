package com.vasitum.assessmentengine.userprofile.service;

import com.vasitum.assessmentengine.security.RegisterUserRequest;
import com.vasitum.assessmentengine.userprofile.model.UserProfile;

public interface UserProfileService {
    UserProfile create(RegisterUserRequest userRequest,String clientToken);
}
