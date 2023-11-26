package com.pawelnu.datafaker.model.pc;

import java.util.UUID;

public class PC {

    private UUID id;
    private String processorBrandUuid;
    private String processorName;
    private String graphicsCardBrandUuid;
    private String graphicsCardName;
    private Integer ramGbCapacity;
    private Integer driveGbCapacity;
    private String driveType;
    private String operatingSystemUuid;
    private String price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProcessorBrandUuid() {
        return processorBrandUuid;
    }

    public void setProcessorBrandUuid(String processorBrandUuid) {
        this.processorBrandUuid = processorBrandUuid;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public String getGraphicsCardBrandUuid() {
        return graphicsCardBrandUuid;
    }

    public void setGraphicsCardBrandUuid(String graphicsCardBrandUuid) {
        this.graphicsCardBrandUuid = graphicsCardBrandUuid;
    }

    public String getGraphicsCardName() {
        return graphicsCardName;
    }

    public void setGraphicsCardName(String graphicsCardName) {
        this.graphicsCardName = graphicsCardName;
    }

    public Integer getRamGbCapacity() {
        return ramGbCapacity;
    }

    public void setRamGbCapacity(Integer ramGbCapacity) {
        this.ramGbCapacity = ramGbCapacity;
    }

    public Integer getDriveGbCapacity() {
        return driveGbCapacity;
    }

    public void setDriveGbCapacity(Integer driveGbCapacity) {
        this.driveGbCapacity = driveGbCapacity;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getOperatingSystemUuid() {
        return operatingSystemUuid;
    }

    public void setOperatingSystemUuid(String operatingSystemUuid) {
        this.operatingSystemUuid = operatingSystemUuid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PC{" +
                "id=" + id +
                ", processor_brand_uuid=" + processorBrandUuid +
                ", processor_name='" + processorName + '\'' +
                ", graphics_card_brand_uuid=" + graphicsCardBrandUuid +
                ", graphics_card_name='" + graphicsCardName + '\'' +
                ", ram_gb_capacity=" + ramGbCapacity +
                ", drive_gb_capacity=" + driveGbCapacity +
                ", drive_type='" + driveType + '\'' +
                ", operating_system_uuid=" + operatingSystemUuid +
                ", price=" + price +
                '}';
    }

    public String toCSVString() {
        return id +
                "," + processorBrandUuid +
                "," + processorName +
                "," + graphicsCardBrandUuid +
                "," + graphicsCardName +
                "," + ramGbCapacity +
                "," + driveGbCapacity +
                "," + driveType +
                "," + operatingSystemUuid +
                "," + price + "\n";
    }
}
