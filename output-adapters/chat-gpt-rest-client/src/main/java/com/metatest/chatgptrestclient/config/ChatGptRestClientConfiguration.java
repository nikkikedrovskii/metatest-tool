package com.metatest.chatgptrestclient.config;

import com.metatest.chatgptrestclient.factory.ChatGptWebClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Configuration
public class ChatGptRestClientConfiguration {

    private final ChatGptWebClientFactory chatGptWebClientFactory;

    @Bean(ChatGptClientBeanMetadata.CHAT_GPT_BEAN_WEBCLIENT)
    public WebClient createWebClient() {
        return chatGptWebClientFactory.create("https://api.openai.com");
    }
}
