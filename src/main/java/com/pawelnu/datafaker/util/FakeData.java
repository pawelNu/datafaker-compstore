package com.pawelnu.datafaker.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class FakeData {

    /**
     * @param min range from.
     * @param max range to.
     * @return Random int from chosen range.
     */
    public static int getIntBetween(int min, int max) {
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
        BigDecimal a = new BigDecimal(randomValue);
        BigDecimal roundOff = a.setScale(1, BigDecimal.ROUND_HALF_EVEN);
        return roundOff.doubleValue();
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
