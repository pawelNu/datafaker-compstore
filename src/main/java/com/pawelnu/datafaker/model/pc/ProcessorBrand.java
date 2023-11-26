package com.pawelnu.datafaker.model.pc;

public class ProcessorBrand {

    private String id;
    private String name;

    public ProcessorBrand(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProcessorBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
