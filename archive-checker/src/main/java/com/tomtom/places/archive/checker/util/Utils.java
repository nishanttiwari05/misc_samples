package com.tomtom.places.archive.checker.util;

import org.apache.commons.lang.StringUtils;

public final class Utils {

    public static double getScaledLevenshteinDistance(CharSequence name1, CharSequence name2) {
        if (name1 == null || name2 == null) {
            throw new IllegalArgumentException("CharSequence must not be null for Scaled Levenshtein Distance calculation");
        }
        return getScaledLevenshteinDistance(name1.toString(), name2.toString());
    }

    public static double getScaledLevenshteinDistance(String name1, String name2) {
        if (name1 == null || name2 == null) {
            throw new IllegalArgumentException("Strings must not be null for Scaled Levenshtein Distance calculation");
        }
        return calculateScaledLevenshteinDistance(name1, name2);
    }

    private static double calculateScaledLevenshteinDistance(String name1, String name2) {
        float lavensteinDist = StringUtils.getLevenshteinDistance(name1, name2);
        float maxLength = Math.max(name1.length(), name2.length());
        return roundTo2Decimals((1 - lavensteinDist / maxLength) * 100);
    }

    private static double roundTo2Decimals(double value) {
        return Math.round(value * 100d) / 100d;
    }
}
