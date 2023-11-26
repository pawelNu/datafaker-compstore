package com.pawelnu.datafaker.service;

import com.pawelnu.datafaker.util.FakeData;

import java.util.ArrayList;
import java.util.List;

public class GPUGeneratorService {
    public static String generateGPUName(String brand) {
        String gpuName = "";

        if (brand.equalsIgnoreCase("AMD")) {
            gpuName = generateAMD();
        } else if (brand.equalsIgnoreCase("Intel")) {
            gpuName = generateIntel();
        } else if (brand.equalsIgnoreCase("NVIDIA")) {
            gpuName = generateNVIDIA();
        }

        return gpuName;
    }

    private static String generateNVIDIA() {
        // NVIDIA GeForce RTX 3060
        int num1 = FakeData.getRandomInt(2,4);
        int num2 = FakeData.getRandomInt(6,9);
        List<String> sufixList = List.of("", " Super", " Ti");
        String suffix = FakeData.getRandomElement(sufixList);

        return "NVIDIA GeForce RTX " + num1 + "0" + num2 + "0" + suffix;
    }

    private static String generateIntel() {
        // Intel UHD Graphics 710
        List<String> numList = List.of("710", "730", "770");
        String num = FakeData.getRandomElement(numList);

        return "Intel UHD Graphics " + num;
    }

    private static String generateAMD() {
        // AMD Radeon RX 6600
        int num1 = FakeData.getRandomInt(5,9);
        int num2 = FakeData.getRandomInt(5,9);
        List<String> sufixList = List.of("", " XT");
        String suffix = FakeData.getRandomElement(sufixList);

        return "AMD Radeon RX " + num1 + num2 + "00" + suffix;
    }
}
