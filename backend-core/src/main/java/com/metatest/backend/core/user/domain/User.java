package com.metatest.backend.core.user.domain;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String name;

    private String email;

    private String password;
}
