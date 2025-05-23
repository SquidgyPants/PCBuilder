package com.example.backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Build {
    private UUID id;
    private String name;
    private Double price;
    private String creator;

    private List<Part> parts;
}

