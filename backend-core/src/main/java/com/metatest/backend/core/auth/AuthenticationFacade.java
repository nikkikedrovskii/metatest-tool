package com.metatest.backend.core.auth;

import com.metatest.backend.core.auth.domain.Signup;
import com.metatest.backend.core.auth.use_case.AuthenticationUseCase;
import com.metatest.backend.core.auth.use_case.SignupUserUseCase;
import com.metatest.backend.core.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade {

    private final AuthenticationUseCase authenticationUseCase;
    private final SignupUserUseCase signupUserUseCase;

    public UserDetails loadUserByEmail(String email) {
        return authenticationUseCase.execute(email);
    }

    public User signupUser(Signup signup) {
        return signupUserUseCase.execute(signup);
    }
}
