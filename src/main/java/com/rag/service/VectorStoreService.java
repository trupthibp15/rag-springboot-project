package com.rag.service;

import com.rag.model.Chunk;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VectorStoreService {

    private final List<Chunk> store = new ArrayList<>();

    public void save(Chunk chunk) {
        store.add(chunk);
    }

    public List<Chunk> search(List<Double> queryEmbedding, int topK) {
        return store.stream()
                .sorted((a, b) -> Double.compare(
                        cosineSimilarity(b.getEmbedding(), queryEmbedding),
                        cosineSimilarity(a.getEmbedding(), queryEmbedding)))
                .limit(topK)
                .toList();
    }

    private double cosineSimilarity(List<Double> a, List<Double> b) {
        double dot = 0, normA = 0, normB = 0;

        for (int i = 0; i < a.size(); i++) {
            dot += a.get(i) * b.get(i);
            normA += Math.pow(a.get(i), 2);
            normB += Math.pow(b.get(i), 2);
        }

        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }

	public void add(String chunk, List<Double> embedding) {
		// TODO Auto-generated method stub
		
	}
}