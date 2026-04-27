package com.rag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.nio.file.*;

import com.rag.model.Chunk;
import com.rag.model.QueryResponse;

@Service
public class RagService {

    private List<Chunk> storedChunks = new ArrayList<>();

    @Autowired
    private EmbeddingService embeddingService;
    public String syncDrive() {
        storedChunks.clear();

        try {
            String content = new String(
                Files.readAllBytes(
                    Paths.get("demo.txt")
                )
            );

            List<String> chunks = Arrays.asList(content.split("\\."));

            for (String chunk : chunks) {
                List<Double> embedding = embeddingService.getEmbedding(chunk);
                storedChunks.add(new Chunk(chunk.trim(), embedding));
            }

        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }

        return "File processed successfully!";
    }
	public QueryResponse ask(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}