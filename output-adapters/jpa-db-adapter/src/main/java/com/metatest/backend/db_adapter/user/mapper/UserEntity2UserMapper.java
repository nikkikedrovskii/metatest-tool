package com.metatest.backend.db_adapter.user.mapper;

import com.metatest.backend.core.user.domain.User;
import com.metatest.backend.jpa.repository.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntity2UserMapper {

    User map(UserEntity userEntity);

}
