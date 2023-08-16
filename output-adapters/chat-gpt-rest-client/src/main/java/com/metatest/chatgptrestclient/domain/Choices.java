package com.metatest.chatgptrestclient.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Choices {

    Long id;
    Message message;

}
