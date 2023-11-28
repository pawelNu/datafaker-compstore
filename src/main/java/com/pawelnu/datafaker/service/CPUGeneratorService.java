package com.pawelnu.datafaker.service;

import com.pawelnu.datafaker.util.FakeData;

import java.math.BigDecimal;
import java.util.List;

public class CPUGeneratorService {

    public static String generateCPUName(String brand) {
        String cpuName = "";

        if (brand.equalsIgnoreCase("AMD")) {
            cpuName = generateAMD();
        } else if (brand.equalsIgnoreCase("Intel")) {
            cpuName = generateIntel();
        }

        return cpuName;
    }

    private static String generateIntel() {
        // Intel Core i7 13gen 13700KF 3,4 - 5,4 GHz

        List<String> iList = List.of("5", "7", "9");
        String iNum = FakeData.getRandomElement(iList);
        int genNum = FakeData.getIntBetween(8, 13);
        double clockingFrom = FakeData.getRandomDouble(2.0, 3.0);
        double clockingTo = clockingFrom + FakeData.getRandomDouble(1.0, 2.0);

        BigDecimal a = new BigDecimal(clockingTo);
        BigDecimal roundOff = a.setScale(1, BigDecimal.ROUND_HALF_EVEN);
        clockingTo = roundOff.doubleValue();

        return "Intel Core i" + iNum + " " + genNum + "gen " + genNum + iNum + "00 " + clockingFrom + " - " + clockingTo + " GHz";
    }

    private static String generateAMD() {
        // AMD Ryzen 5 3600 3,6 - 4,2 GHz

        int genNum = FakeData.getIntBetween(5, 9);
        int series = FakeData.getIntBetween(3, 7);
        int series2 = FakeData.getIntBetween(5, 9);
        double clockingFrom = FakeData.getRandomDouble(2.0, 3.5);
        double clockingTo = clockingFrom + FakeData.getRandomDouble(1.2, 2.5);

        BigDecimal a = new BigDecimal(clockingTo);
        BigDecimal roundOff = a.setScale(1, BigDecimal.ROUND_HALF_EVEN);
        clockingTo = roundOff.doubleValue();

        return "AMD Ryzen " + genNum + " " + series + series2 + "00 " + clockingFrom + " - " + clockingTo + " GHz";
    }

}
