package com.metatest.backend.core.auth.domain;

import lombok.Data;

@Data
public class Signup {

    private String name;

    private String email;

    private String password;
}
