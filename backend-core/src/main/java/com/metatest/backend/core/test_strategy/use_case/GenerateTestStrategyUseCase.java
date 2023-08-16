package com.metatest.backend.core.test_strategy.use_case;

import com.metatest.backend.core.chatgpt.component.ChatGptGenerateTestStrategyComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerateTestStrategyUseCase {

    private final ChatGptGenerateTestStrategyComponent chatGptGenerateTestStrategyComponent;

    public String execute(String textOfDocument) {
        return chatGptGenerateTestStrategyComponent.generateTestStrategy(textOfDocument);
    }

}
