package com.pawelnu.datafaker.logic;

import com.pawelnu.datafaker.model.pc.GraphicsCardBrand;
import com.pawelnu.datafaker.model.pc.OperatingSystem;
import com.pawelnu.datafaker.model.pc.PC;
import com.pawelnu.datafaker.model.pc.ProcessorBrand;

import java.util.List;

import static com.pawelnu.datafaker.service.PCGeneratorService.*;

public class CreatePCData {

    private static final String pcProcessorBrandsFile =
            "C:\\Users\\pawel.nurzynski\\Desktop\\Folder\\projects\\compstore\\api\\src\\main\\resources\\db\\changelog\\0.1.0\\test_data\\pc\\pc-processor-brands.csv";

    private static final String pcGraphicsCardBrandsFile =
            "C:\\Users\\pawel.nurzynski\\Desktop\\Folder\\projects\\compstore\\api\\src\\main\\resources\\db\\changelog\\0.1.0\\test_data\\pc\\pc-graphics-card-brands.csv";

    private static final String pcOperatingSystemsFile =
            "C:\\Users\\pawel.nurzynski\\Desktop\\Folder\\projects\\compstore\\api\\src\\main\\resources\\db\\changelog\\0.1.0\\test_data\\pc\\pc-operating-systems.csv";

    public static void createPCData() {

        List<ProcessorBrand> processorBrands = readProcessorBrandsFromCSV(pcProcessorBrandsFile);
        List<GraphicsCardBrand> graphicsCardBrands = readGraphicsCardBrandsFromCSV(pcGraphicsCardBrandsFile);
        List<OperatingSystem> operatingSystems = readOperatingSystemsFromCSV(pcOperatingSystemsFile);

        List<PC> pcs = generatePCs(processorBrands, graphicsCardBrands, operatingSystems,100);

        writePCsToCSV(pcs, "pcs.csv");
    }

}
