package com.metatest.backend.core.file;

import com.metatest.backend.core.file.use_case.ExportResponse2ExcelUseCase;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FileFacade {

    private final ExportResponse2ExcelUseCase exportResponse2ExcelUseCase;

    public void exportResponse2Excel(String textStrategyFromGtp, HttpServletResponse response) throws IOException {
        exportResponse2ExcelUseCase.execute(textStrategyFromGtp, response);
    }
}
