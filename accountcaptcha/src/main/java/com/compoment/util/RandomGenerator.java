package com.compoment.util;

import java.util.Random;

public class RandomGenerator {

    private static String range = "0123456789abcefghijkmnopqrstuvwxyz";

    public static synchronized String getRandonString() {

        Random random = new Random();

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < 8; i++) {

            result.append(range.charAt(random.nextInt(range.length())));
        }

        return result.toString();
    }
}
