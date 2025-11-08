package com.kenny.kenny_ai.utils;

public class VectorDistanceUtils {

    // Prevent instantiation
    private VectorDistanceUtils() {}

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