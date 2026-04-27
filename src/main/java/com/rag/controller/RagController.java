package com.rag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rag.service.RagService;
import com.rag.model.QueryRequest;
import com.rag.model.QueryResponse;

@RestController
@RequestMapping("/api")
public class RagController {

    @Autowired
    private RagService ragService;

    @PostMapping("/sync-drive")
    public String syncDrive() {
        return ragService.syncDrive();
    }

    @PostMapping("/ask")
    public QueryResponse ask(@RequestBody QueryRequest request) {
        return ragService.ask(request.getQuery());
    }
}