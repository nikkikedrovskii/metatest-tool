package com.metatest.backend.entrypoint.rest.mapper;

import com.metatest.backend.core.auth.domain.Signup;
import com.metatest.backend.entrypoint.rest.model.input.SignupRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SignupRequest2SignupMapper {

    Signup map(SignupRequest signupRequest);

}
