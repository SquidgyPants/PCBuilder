package com.example.backend.Enums;

import lombok.Getter;

@Getter
public enum Type {
    CPU(1, "CPU"),
    GPU(2, "GPU"),
    RAM(3, "RAM"),
    MOTHERBOARD(4, "Motherboard"),
    STORAGE(5, "Storage"),
    POWER_SUPPLY(6, "Power Supply"),
    CASE(7, "Case"),
    COOLER(8, "Cooler");

    private final int code;
    private final String label;

    public String fromCode(int code) {
        for (Type type : Type.values()) {
            if (type.code == code) {
                return type.label;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    Type(int code, String label) {
        this.code = code;
        this.label = label;
    }
}
