package com.rag.model;

import java.util.List;

public class Chunk {

    private String content;
    private List<Double> embedding;

    public Chunk(String content, List<Double> embedding) {
        this.content = content;
        this.embedding = embedding;
    }

    public String getContent() {
        return content;
    }

    public List<Double> getEmbedding() {
        return embedding;
    }
}