package com.metatest.chatgptrestclient.factory;

import com.metatest.chatgptrestclient.common.RestWebClientBuilderProvider;
import com.metatest.chatgptrestclient.config.ChatGptHttpClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Component
@RequiredArgsConstructor
public class ChatGptWebClientFactory {

    private final ChatGptHttpClientFactory chatGptHttpClientFactory;
    private final RestWebClientBuilderProvider restWebClientBuilderProvider;

    public WebClient create(String baseUrl) {

        var httpClient = createHttpClient();

        var size = 16 * 1024 * 1024;

        var strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();

        return restWebClientBuilderProvider
                .provide(baseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .exchangeStrategies(strategies)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    private HttpClient createHttpClient(){
        return chatGptHttpClientFactory.createChatGptHttpClient();
    }
}
