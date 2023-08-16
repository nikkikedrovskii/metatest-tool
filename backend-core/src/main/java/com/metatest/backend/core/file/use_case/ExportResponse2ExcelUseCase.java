package com.metatest.backend.core.file.use_case;

import com.metatest.backend.core.auth.use_case.SignupUserUseCase;
import com.metatest.backend.core.file.component.UserExcelExporter;
import com.metatest.backend.core.file.domain.TestStrategy;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExportResponse2ExcelUseCase {

    private final UserExcelExporter userExcelExporter;

    public void execute(String textStrategyFromGtp, HttpServletResponse response) throws IOException {
        userExcelExporter.export(response, converToList(textStrategyFromGtp));
    }

    private List<TestStrategy> converToList(String chatResult){
        var stringTable = chatResult.substring(chatResult.indexOf("|"), chatResult.lastIndexOf("|"));
        var splitResult = stringTable.split("\n");

        var listOfTestStrategy = new ArrayList<TestStrategy>();

        Arrays.stream(splitResult).skip(2).forEach(element -> {
            var buffer = element.split("\\|");
            var testStrategy = TestStrategy.builder()
                    .id(buffer[1])
                    .description(buffer[2].replace("<br/>",". ").replace("<br>",". "))
                    .conditions(buffer[3].replace("<br/>",". ").replace("<br>",". "))
                    .steps(buffer[4].replace("<br/>",". ").replace("<br>",". "))
                    .output(buffer[5].replace("<br/>",". ").replace("<br>",". "))
                    .build();
            listOfTestStrategy.add(testStrategy);
        });
        return listOfTestStrategy;
    }

}
