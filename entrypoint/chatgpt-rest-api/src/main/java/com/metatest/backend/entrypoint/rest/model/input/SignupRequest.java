package com.metatest.backend.entrypoint.rest.model.input;

import lombok.Data;

@Data
public class SignupRequest {

    private String name;

    private String email;

    private String password;

}
