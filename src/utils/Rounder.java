package utils;

import java.text.DecimalFormat;

public class Rounder {

    public static String round(double value, String pattern) {
        return new DecimalFormat(pattern).format(value);
    }
}
