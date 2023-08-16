package com.metatest.chatgptrestclient.client;

import com.metatest.chatgptrestclient.config.ChatGptRestConfigurationProperties;
import com.metatest.chatgptrestclient.config.SuccessResponseHandler;
import com.metatest.chatgptrestclient.domain.ChatGptRequest;
import com.metatest.chatgptrestclient.domain.ChatGptResponse;
import com.metatest.chatgptrestclient.factory.ChatGptWebClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ChatGptRestClient {

    private final ChatGptWebClientFactory chatGptWebClientFactory;
    private final SuccessResponseHandler successResponseHandler;
    private final ChatGptRestConfigurationProperties chatGptRestConfigurationProperties;

    public ChatGptResponse generateTestStrategy(ChatGptRequest chatGptRequest) {

     //   var baseUrl = chatGptRestConfigurationProperties.getBaseUrl();
     //   var accessToken = chatGptRestConfigurationProperties.getAccessToken();
     // var webClient = chatGptWebClientFactory.create(baseUrl);
        var webClient = chatGptWebClientFactory.create("https://api.openai.com");
        var callSpec = webClient.post()
                .uri("/v1/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","Bearer " + "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")
                .body(BodyInserters.fromValue(chatGptRequest));

        var response = callSpec.exchange().block();

        return toResponse(response, ChatGptResponse.class, Function.identity());
    }

    private <T, U> U toResponse(
            ClientResponse clientResponse,
            Class<T> responseBodyType,
            Function<T, U> responseBodyMapper) {

        return successResponseHandler
                .successResponse(clientResponse, responseBodyType, responseBodyMapper);
    }

}
