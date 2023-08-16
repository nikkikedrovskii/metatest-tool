package com.metatest.chatgptrestclient.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant"),
    ;
    private String value;

}
