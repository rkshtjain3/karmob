package com.vasitum.assessmentengine.security;

import com.vasitum.assessmentengine.userprofile.model.UserProfile;
import com.vasitum.assessmentengine.userprofile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserProfileRepository userProfileRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileRepository.findByRpn(Long.parseLong(s));
        return UserPrincipal.create(userProfile);
    }
    @Transactional
    public UserDetails loadUserById(Long id) {
        Optional<UserProfile> user = userProfileRepository.findById(id);
        return UserPrincipal.create(user.get());
    }
}
