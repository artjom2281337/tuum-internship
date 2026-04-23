package com.example.tuum.model;

import java.util.Arrays;

public enum Currency {
    EUR, SEK, GBP, USD;

    public static boolean isValid(String currencyCode) {
        if (currencyCode == null) {
            return false;
        }
        return Arrays.stream(Currency.values()).anyMatch(c -> c.name().equals(currencyCode.toUpperCase()));
    }
}
