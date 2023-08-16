package com.metatest.backend.entrypoint.rest.model.input;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;

}
