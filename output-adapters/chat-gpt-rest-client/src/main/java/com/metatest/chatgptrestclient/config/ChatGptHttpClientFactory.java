package com.metatest.chatgptrestclient.config;

import org.springframework.stereotype.Component;
import reactor.netty.http.client.HttpClient;

@Component
public class ChatGptHttpClientFactory {

    private static final int MAX_RESPONSE_HEADER_SIZE = 16_384;

    public HttpClient createChatGptHttpClient() {

        return HttpClient
                .create()
                .httpResponseDecoder(
                        httpResponseDecoderSpec -> httpResponseDecoderSpec.maxHeaderSize(MAX_RESPONSE_HEADER_SIZE));
    }
}
