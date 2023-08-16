package com.metatest.backend.entrypoint.rest.controller;

import com.metatest.backend.entrypoint.rest.adapter.TestStrategyAdapter;
import com.metatest.backend.entrypoint.rest.model.output.TestStrategyResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ChatGptController {

    private final TestStrategyAdapter testStrategyAdapter;

    @PostMapping(value = {"/strategy/generate"})
    public ResponseEntity<TestStrategyResponse> generateTestStrategy(@RequestParam("file") MultipartFile file) throws IOException {
        String requestText = null;

        if (!file.isEmpty()) {
            InputStream inputStream = file.getInputStream();
            XWPFDocument document = new XWPFDocument(inputStream);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            requestText = paragraphs.stream()
                    .map(XWPFParagraph::getText)
                    .collect(Collectors.joining("\n"));
        }

        var response = testStrategyAdapter.generateTestStrategy(requestText);
        return ResponseEntity.ok(response);
    }
}
