package com.example.backend.Mappers;


import com.example.backend.DTOs.BuildDTO;
import com.example.backend.DTOs.BuildPartDTO;
import com.example.backend.DTOs.PartDTO;
import com.example.backend.Models.BuildPart;

import java.util.UUID;

public class BuildPartMapper {
    // Method to convert BuildPartDTO to BuildPart
    public static BuildPart toModel(BuildPartDTO buildPartDTO) {
        if (buildPartDTO == null) {
            return null;
        }
        BuildPart buildPart = new BuildPart();
        buildPart.setId(UUID.fromString(buildPartDTO.getId()));
        buildPart.setBuildId(UUID.fromString(buildPartDTO.getBuildDTO().getId()));
        buildPart.setPartId(UUID.fromString(buildPartDTO.getPartDTO().getId()));
        return buildPart;
    }

    // Method to convert BuildPart to BuildPartDTO
    public static BuildPartDTO toDto(BuildPart buildPart) {
        if (buildPart == null) {
            return null;
        }
        BuildPartDTO buildPartDTO = new BuildPartDTO();
        buildPartDTO.setId(buildPart.getId().toString());
        // Assuming you have methods to get the Build and Part DTOs
        BuildDTO buildDTO = new BuildDTO();
        buildDTO.setId(buildPart.getBuildId().toString());
        buildPartDTO.setBuildDTO(buildDTO);

        PartDTO partDTO = new PartDTO();
        partDTO.setId(buildPart.getPartId().toString());
        buildPartDTO.setPartDTO(partDTO);
        return buildPartDTO;
    }
}
