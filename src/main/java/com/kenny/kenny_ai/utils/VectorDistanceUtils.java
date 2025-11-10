package com.kenny.kenny_ai.utils;

public class VectorDistanceUtils {

    // Prevent instantiation
    private VectorDistanceUtils() {}

    // Floating-point precision threshold
    private static final double EPSILON = 1e-12;

    /**
     * Compute Euclidean distance.
     *
     * @param vectorA Vector A (non-null and same length as B)
     * @param vectorB Vector B (non-null and same length as A)
     * @return Euclidean distance
     * @throws IllegalArgumentException if arguments are invalid
     */
    public static double euclideanDistance(float[] vectorA, float[] vectorB) {
        validateVectors(vectorA, vectorB);
        double sum = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            double diff = vectorA[i] - vectorB[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    /**
     * Compute cosine similarity in [-1, 1].
     * If you want cosine distance, use: return 1.0 - similarity;
     *
     * @param vectorA Vector A (non-null and same length as B)
     * @param vectorB Vector B (non-null and same length as A)
     * @return Cosine similarity in [-1, 1]
     * @throws IllegalArgumentException if arguments are invalid or vectors are zero
     */
    public static double cosineSimilarity(float[] vectorA, float[] vectorB) {
        validateVectors(vectorA, vectorB);
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += vectorA[i] * vectorA[i];
            normB += vectorB[i] * vectorB[i];
        }

        normA = Math.sqrt(normA);
        normB = Math.sqrt(normB);

        // Handle zero vector case
        if (normA < EPSILON || normB < EPSILON) {
            throw new IllegalArgumentException("Vectors cannot be zero vectors");
        }

        // Clamp to [-1, 1] to handle floating-point error
        double similarity = dotProduct / (normA * normB);
        if (similarity > 1.0) similarity = 1.0;
        else if (similarity < -1.0) similarity = -1.0;

        return similarity;
    }

    // Common argument validation
    private static void validateVectors(float[] a, float[] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Vectors cannot be null");
        }
        if (a.length != b.length) {
            throw new IllegalArgumentException("Vectors must have the same dimension");
        }
        if (a.length == 0) {
            throw new IllegalArgumentException("Vectors cannot be empty");
        }
    }
}