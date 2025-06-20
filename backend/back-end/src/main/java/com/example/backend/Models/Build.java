package com.example.backend.Models;

import com.example.backend.DTOs.BuildPartDTO;
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

    private List<BuildPart> buildParts;

    private List<Part> parts;
    private Part partToAdd;

    private List<Part> allParts;
}

