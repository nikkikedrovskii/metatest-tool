package com.metatest.backend.entrypoint.rest.controller;

import com.metatest.backend.entrypoint.rest.adapter.FileAdapter;
import com.metatest.backend.entrypoint.rest.model.input.ExportText2ExcelRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class FIleController {

    private final FileAdapter fileAdapter;

    @PostMapping(value = "/export/excel")
    public void exportToExcel(HttpServletResponse response, @RequestBody ExportText2ExcelRequest exportText2ExcelRequest) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        fileAdapter.export2Excel(exportText2ExcelRequest.getTextStrategyFromGtp(),response);
    }

}
