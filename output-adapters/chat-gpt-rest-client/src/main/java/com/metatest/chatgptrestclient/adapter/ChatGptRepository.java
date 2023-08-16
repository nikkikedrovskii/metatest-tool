package com.metatest.chatgptrestclient.adapter;

import com.metatest.backend.core.chatgpt.adapter.ChatGtpAdapter;
import com.metatest.chatgptrestclient.client.ChatGptRestClient;
import com.metatest.chatgptrestclient.factory.ChatGptRequestFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatGptRepository implements ChatGtpAdapter {

    private final ChatGptRestClient chatGptRestClient;
    private final ChatGptRequestFactory chatGptRequestFactory;

    @Override
    public String generateTestStrategy(String textOfDocument) {
        var chatGptRequest = chatGptRequestFactory.create(textOfDocument);
        var response = chatGptRestClient.generateTestStrategy(chatGptRequest);
        return response.getChoices().get(0).getMessage().getContent();
    }


}
