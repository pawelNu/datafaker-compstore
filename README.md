# datafaker-compstore

Custom data faker for CompStore Project

https://github.com/grz55/compstore-api

<!-- TOC -->
* [datafaker-compstore](#datafaker-compstore)
  * [Features](#features)
  * [FilePaths class](#filepaths-class)
<!-- TOC -->

## Features

Generates random data for:
- PCs

TODO:
- Laptops
- Smartphones
- TVs

## FilePaths class

```java
public enum FilePaths {
    PC_PROCESSOR_BRANDS_FILE("path\\to\\pc-processor-brands.csv"),
    PC_GRAPHICS_CARD_BRANDS_FILE("path\\to\\pc-graphics-card-brands.csv"),
    PC_OPERATING_SYSTEMS_FILE("path\\to\\pc-operating-systems.csv");

    private final String value;

    FilePaths(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

```