package com.mostafa.semantic.search.controller;


import org.springframework.web.bind.annotation.*;

import com.mostafa.semantic.search.service.DocumentIngestionService;

import java.util.Map;

@RestController
@RequestMapping("/api/ingestion")
public class IngestionController {

    private final DocumentIngestionService ingestionService;

    public IngestionController(DocumentIngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping("/text")
    public Map<String, Object> ingestText(@RequestParam String path) {
        int chunks = ingestionService.ingestTextFile(path);
        return Map.of(
                "message", "Text file ingested successfully",
                "chunksStored", chunks
        );
    }

    @PostMapping("/pdf")
    public Map<String, Object> ingestPdf(@RequestParam String path) {
        int chunks = ingestionService.ingestPdfFile(path);
        return Map.of(
                "message", "PDF file ingested successfully",
                "chunksStored", chunks
        );
    }
}