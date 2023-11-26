package com.pawelnu.datafaker.util;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class FakeData {

    /**
     * @param min range from.
     * @param max range to.
     * @return Random int from chosen range.
     */
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


    /**
     * @param min range from.
     * @param max range to.
     * @return Random double from chosen range.
     */
    public static double getRandomDouble(double min, double max) {
        Random random = new Random();
        double randomValue = min + (max - min) * random.nextDouble();
        return roundToSingleDecimal(Math.round(randomValue * 10.0) / 10.0);
    }

    /**
     * @param list of items from which to choose.
     * @return drawn item.
     */
    public static String getRandomElement(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Lista nie może być pusta lub null.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static double roundToSingleDecimal(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,#");
        return Double.parseDouble(decimalFormat.format(value));
    }

}
