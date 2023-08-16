package com.metatest.backend.core.chatgpt.component;

import com.metatest.backend.core.chatgpt.adapter.ChatGtpAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatGptGenerateTestStrategyComponent {

    private final ChatGtpAdapter chatGtpAdapter;

    public String generateTestStrategy(String textOfDocument) {
        return chatGtpAdapter.generateTestStrategy(textOfDocument);
    }

}
