package com.pawelnu.datafaker.service;

import com.github.javafaker.Faker;
import com.pawelnu.datafaker.model.pc.GraphicsCardBrand;
import com.pawelnu.datafaker.model.pc.OperatingSystem;
import com.pawelnu.datafaker.model.pc.PC;
import com.pawelnu.datafaker.model.pc.ProcessorBrand;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PCGeneratorService {

    public static List<ProcessorBrand> readProcessorBrandsFromCSV(String filename) {
        List<ProcessorBrand> processorBrands = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filename);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader)) {
            for (CSVRecord record : csvParser.getRecords()) {
                String id = record.get("id");
                String name = record.get("name");

                ProcessorBrand processorBrand = new ProcessorBrand(id, name);
                processorBrands.add(processorBrand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return processorBrands;
    }

    public static List<GraphicsCardBrand> readGraphicsCardBrandsFromCSV(String filename) {
        List<GraphicsCardBrand> graphicsCardBrands = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filename);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader)) {

            for (CSVRecord record : csvParser.getRecords()) {
                String id = record.get("id");
                String name = record.get("name");

                GraphicsCardBrand graphicsCardBrand = new GraphicsCardBrand(id, name);
                graphicsCardBrands.add(graphicsCardBrand);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return graphicsCardBrands;
    }

    public static List<OperatingSystem> readOperatingSystemsFromCSV(String filename) {
        List<OperatingSystem> operatingSystems = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filename);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader)) {

            for (CSVRecord record : csvParser.getRecords()) {
                String id = record.get("id");
                String name = record.get("name");

                OperatingSystem operatingSystem = new OperatingSystem(id, name);
                operatingSystems.add(operatingSystem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return operatingSystems;
    }

    public static List<PC> generatePCs(List<ProcessorBrand> processorBrands,
                                       List<GraphicsCardBrand> graphicsCardBrands,
                                       List<OperatingSystem> operatingSystems,
                                       int numberOfRecords) {
        List<PC> pcs = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < numberOfRecords; i++) {
            int indexCPU = i % processorBrands.size();
            String cpuBrandName = processorBrands.get(indexCPU).getName();

            int indexGPU = i % graphicsCardBrands.size();
            String gpuBrandName = graphicsCardBrands.get(indexCPU).getName();

            PC pc = new PC();
            pc.setId(UUID.randomUUID());
            pc.setProcessorBrandUuid(processorBrands.get(indexCPU).getId());
            pc.setProcessorName("\"" + CPUGeneratorService.generateCPUName(cpuBrandName) + "\"");
            pc.setGraphicsCardBrandUuid(graphicsCardBrands.get(indexGPU).getId());
            pc.setGraphicsCardName("\"" + GPUGeneratorService.generateGPUName(gpuBrandName) + "\"");
            pc.setRamGbCapacity(faker.number().numberBetween(8, 64));
            pc.setDriveGbCapacity(faker.number().numberBetween(256, 2048));
            pc.setDriveType("SSD");
            pc.setOperatingSystemUuid(operatingSystems.get(i % operatingSystems.size()).getId());
            pc.setPrice(faker.number().numberBetween(900, 9999) + "." + faker.number().numberBetween(10, 99));

            pcs.add(pc);
        }

        return pcs;
    }

    public static void writePCsToCSV(List<PC> pcs, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("id,processor_brand_uuid,processor_name,graphics_card_brand_uuid,graphics_card_name,");
            writer.append("ram_gb_capacity,drive_gb_capacity,drive_type,operating_system_uuid,price\n");

            for (PC pc : pcs) {
                writer.append(pc.toCSVString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
