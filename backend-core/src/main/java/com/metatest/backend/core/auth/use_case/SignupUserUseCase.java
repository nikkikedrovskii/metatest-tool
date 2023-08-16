package com.metatest.backend.core.auth.use_case;

import com.metatest.backend.core.auth.domain.Signup;
import com.metatest.backend.core.user.adapter.UserRepositoryAdapter;
import com.metatest.backend.core.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupUserUseCase {

    private final UserRepositoryAdapter userRepositoryAdapter;

    public User execute(Signup signup) {
        return userRepositoryAdapter.saveUser(signup);
    }
}
