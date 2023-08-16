package com.metatest.backend.core.test_strategy;

import com.metatest.backend.core.test_strategy.use_case.GenerateTestStrategyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestStrategyFacade {

    private final GenerateTestStrategyUseCase generateTestStrategyUseCase;

    public String getListOfPaymentMethod(String textOfDocument) {
        return generateTestStrategyUseCase.execute(textOfDocument);
    }

}
