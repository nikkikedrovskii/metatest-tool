package com.metatest.backend.entrypoint.rest.adapter;

import com.metatest.backend.core.test_strategy.TestStrategyFacade;
import com.metatest.backend.entrypoint.rest.model.output.TestStrategyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TestStrategyAdapter {

    private final TestStrategyFacade testStrategyFacade;

    public TestStrategyResponse generateTestStrategy(String textOfDocument) {

        var testStrategy = testStrategyFacade.getListOfPaymentMethod(textOfDocument);

        return TestStrategyResponse.builder()
                .testStrategy(testStrategy)
                .build();
    }

}
