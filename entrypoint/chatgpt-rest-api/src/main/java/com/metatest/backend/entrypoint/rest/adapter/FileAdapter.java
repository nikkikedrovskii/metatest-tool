package com.metatest.backend.entrypoint.rest.adapter;

import com.metatest.backend.core.file.FileFacade;
import com.metatest.backend.core.test_strategy.TestStrategyFacade;
import com.metatest.backend.entrypoint.rest.model.output.TestStrategyResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FileAdapter {

    private final FileFacade fileFacade;

    public void export2Excel(String textStrategyFromGtp, HttpServletResponse response) throws IOException {
        fileFacade.exportResponse2Excel(textStrategyFromGtp, response);
    }
}
