package com.rag.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DriverService {

    // Mock documents (simulate Google Drive)
    public Map<String, String> fetchDocuments() {
        Map<String, String> docs = new HashMap<>();

        docs.put("policy.txt",
                "Refund policy allows returns within 30 days. Items must be unused.");

        docs.put("compliance.txt",
                "Company follows strict compliance rules and audit procedures.");

        return docs;
    }
}