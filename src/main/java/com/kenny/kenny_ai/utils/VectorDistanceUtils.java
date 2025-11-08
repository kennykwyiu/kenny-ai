package com.kenny.kenny_ai.utils;

public class VectorDistanceUtils {

    // Prevent instantiation
    private VectorDistanceUtils() {}

    // Floating-point precision threshold
    private static final double EPSILON = 1e-12;

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