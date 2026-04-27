package com.rag.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmbeddingService {

    public List<Double> getEmbedding(String text) {
        List<Double> embedding = new ArrayList<>();

        for (char c : text.toCharArray()) {
            embedding.add((double) c / 100);
        }

        return embedding;
    }
}