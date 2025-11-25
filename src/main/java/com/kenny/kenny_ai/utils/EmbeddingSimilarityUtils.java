package com.kenny.kenny_ai.utils;

import java.util.Locale;

/**
 * Utilities for computing similarity/distance on text embeddings.
 * Model-agnostic: works with nomic-embed-text, text-embedding-3, etc.
 */
public final class EmbeddingSimilarityUtils {

    private EmbeddingSimilarityUtils() {}
    private static final double EPSILON = 1e-12;

    /** Euclidean distance (smaller = more similar). Best used on L2-normalized vectors. */
    public static double euclideanDistance(float[] a, float[] b) {
        validate(a, b);
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = a[i] - b[i];
            sum += d * d;
        }
        return Math.sqrt(sum);
    }

    /** Cosine similarity in [-1, 1] (larger = more similar). */
    public static double cosineSimilarity(float[] a, float[] b) {
        validate(a, b);
        double dot = 0.0, na = 0.0, nb = 0.0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            na  += a[i] * a[i];
            nb  += b[i] * b[i];
        }
        na = Math.sqrt(na);
        nb = Math.sqrt(nb);
        if (na < EPSILON || nb < EPSILON) {
            throw new IllegalArgumentException("Vectors cannot be zero vectors");
        }
        double sim = dot / (na * nb);
        if (sim > 1.0) sim = 1.0;
        else if (sim < -1.0) sim = -1.0;
        return sim;
    }

    /** Cosine distance in [0, 2]. 0 means identical direction. */
    public static double cosineDistance(float[] a, float[] b) {
        return 1.0 - cosineSimilarity(a, b);
    }

    /** Helper to format a comparison line. */
    public static String formatComparisonLine(int idx, double cosSim, double l2, String label) {
        return String.format(Locale.ROOT, "%d | cos=%.4f | l2=%.4f | %s", idx, cosSim, l2, label);
    }

    private static void validate(float[] a, float[] b) {
        if (a == null || b == null) throw new IllegalArgumentException("Vectors cannot be null");
        if (a.length != b.length) throw new IllegalArgumentException("Vectors must have same dimension");
        if (a.length == 0) throw new IllegalArgumentException("Vectors cannot be empty");
    }
}
