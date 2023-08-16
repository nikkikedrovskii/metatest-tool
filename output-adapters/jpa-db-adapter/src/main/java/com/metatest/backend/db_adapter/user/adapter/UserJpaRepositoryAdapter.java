package com.metatest.backend.db_adapter.user.adapter;

import com.metatest.backend.core.auth.domain.Signup;
import com.metatest.backend.core.user.adapter.UserRepositoryAdapter;
import com.metatest.backend.core.user.domain.User;
import com.metatest.backend.db_adapter.user.mapper.UserEntity2UserMapper;
import com.metatest.backend.jpa.repository.entity.UserEntity;
import com.metatest.backend.jpa.repository.jpa.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserRepositoryAdapter {

     private final UserEntityRepository userEntityRepository;
    private final UserEntity2UserMapper userEntity2UserMapper;

    @Override
    public User findUserByEmail(String email) {
        var user = userEntityRepository.findFirstByEmail(email)
                .orElseThrow(() -> new RuntimeException("user does not exist"));
        return userEntity2UserMapper.map(user);
    }

    @Override
    @Transactional
    public User saveUser(Signup signup) {
        var userEntity = new UserEntity();
        userEntity.setExternalCustomerId(UUID.randomUUID());
        userEntity.setEmail(signup.getEmail());
        userEntity.setName(signup.getName());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(signup.getPassword()));

        var createdUser = userEntityRepository.save(userEntity);
        var user = new User();
        user.setId(createdUser.getId());
        user.setEmail(createdUser.getEmail());
        user.setName(createdUser.getName());
        return user;
    }


}
