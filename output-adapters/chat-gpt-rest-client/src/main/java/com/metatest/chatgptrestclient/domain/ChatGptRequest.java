package com.metatest.chatgptrestclient.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ChatGptRequest {

    String model;

    List<Message> messages;

    Integer max_tokens;
}
