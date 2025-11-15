package com.kenny.kenny_ai.utils;

import java.util.Locale;

/**
 * Utilities for computing similarity/distance on text embeddings.
 * Model-agnostic: works with nomic-embed-text, text-embedding-3, etc.
 */
public final class EmbeddingSimilarityUtils {

    private EmbeddingSimilarityUtils() {}

    private static void validate(float[] a, float[] b) {
        if (a == null || b == null) throw new IllegalArgumentException("Vectors cannot be null");
        if (a.length != b.length) throw new IllegalArgumentException("Vectors must have same dimension");
        if (a.length == 0) throw new IllegalArgumentException("Vectors cannot be empty");
    }
}
