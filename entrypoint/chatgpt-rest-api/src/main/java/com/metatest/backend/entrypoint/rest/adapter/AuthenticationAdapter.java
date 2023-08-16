package com.metatest.backend.entrypoint.rest.adapter;

import com.metatest.backend.core.auth.AuthenticationFacade;
import com.metatest.backend.core.auth.domain.Signup;
import com.metatest.backend.core.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationAdapter {

    private final AuthenticationFacade authenticationFacade;

    public UserDetails loadUserByEmail(String email) {
        return authenticationFacade.loadUserByEmail(email);
    }

    public User signupUser(Signup signup) {
        return authenticationFacade.signupUser(signup);
    }

}
