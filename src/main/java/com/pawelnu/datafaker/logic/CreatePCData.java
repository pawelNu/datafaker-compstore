package com.pawelnu.datafaker.logic;

import com.pawelnu.datafaker.model.pc.GraphicsCardBrand;
import com.pawelnu.datafaker.model.pc.OperatingSystem;
import com.pawelnu.datafaker.model.pc.PC;
import com.pawelnu.datafaker.model.pc.ProcessorBrand;
import com.pawelnu.datafaker.service.FilePaths;

import java.util.List;

import static com.pawelnu.datafaker.service.PCGeneratorService.*;

public class CreatePCData {

    private static final String pcProcessorBrandsFile = FilePaths.PC_PROCESSOR_BRANDS_FILE.getValue();
    private static final String pcGraphicsCardBrandsFile = FilePaths.PC_GRAPHICS_CARD_BRANDS_FILE.getValue();
    private static final String pcOperatingSystemsFile = FilePaths.PC_OPERATING_SYSTEMS_FILE.getValue();

    public static void createPCData() {

        List<ProcessorBrand> processorBrands = readProcessorBrandsFromCSV(pcProcessorBrandsFile);
        List<GraphicsCardBrand> graphicsCardBrands = readGraphicsCardBrandsFromCSV(pcGraphicsCardBrandsFile);
        List<OperatingSystem> operatingSystems = readOperatingSystemsFromCSV(pcOperatingSystemsFile);

        List<PC> pcs = generatePCs(processorBrands, graphicsCardBrands, operatingSystems,100);

        writePCsToCSV(pcs, "pcs.csv");
    }

}
