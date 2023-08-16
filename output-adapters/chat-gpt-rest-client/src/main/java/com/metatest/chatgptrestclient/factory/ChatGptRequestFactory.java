package com.metatest.chatgptrestclient.factory;

import com.metatest.chatgptrestclient.domain.ChatGptRequest;
import com.metatest.chatgptrestclient.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChatGptRequestFactory {

    private static final String GPT_4 = "gpt-4";

    public ChatGptRequest create(String requestMessage){

        var userMessage = Message.of(requestMessage);
        var system = Message.ofSystem("You're a helper to create testing strategies from the documentation text provided. Write in the table. Columns: Name, Priority, Conditions, Stages of execution, Result.");

        var messagesChain = List.of(system,userMessage);

        return ChatGptRequest.builder()
                .model(GPT_4)
                .messages(messagesChain)
                .max_tokens(7000)
                .build();

    }

}
