package com.metatest.backend.core.user.adapter;

import com.metatest.backend.core.auth.domain.Signup;
import com.metatest.backend.core.user.domain.User;

public interface UserRepositoryAdapter {

    User findUserByEmail(String email);

    User saveUser(Signup signup);

}
