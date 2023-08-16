package com.metatest.chatgptrestclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app.delle")
public class ChatGptRestConfigurationProperties {

    String accessToken;
    String baseUrl;
}
