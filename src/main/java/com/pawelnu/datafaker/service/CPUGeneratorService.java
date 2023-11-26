package com.pawelnu.datafaker.service;

import com.pawelnu.datafaker.util.FakeData;

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
        int genNum = FakeData.getRandomInt(8, 13);
        double clockingFrom = FakeData.getRandomDouble(2, 2);
        double clockingTo = clockingFrom + 2;

        return "Intel Core i" + iNum + " " + genNum + "gen " + genNum + iNum + "00 " + clockingFrom + " - " + clockingTo + " GHz";
    }

    private static String generateAMD() {
        // AMD Ryzen 5 3600 3,6 - 4,2 GHz

        int genNum = FakeData.getRandomInt(5, 9);
        int series = FakeData.getRandomInt(3, 7);
        int series2 = FakeData.getRandomInt(5, 9);
        double clockingFrom = FakeData.getRandomDouble(2, 3);
        double clockingTo = clockingFrom + 1.6;

        return "AMD Ryzen " + genNum + " " + series + series2 + "00 " + clockingFrom + " - " + clockingTo + " GHz";
    }

}
