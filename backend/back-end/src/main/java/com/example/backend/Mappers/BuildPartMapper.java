package com.example.backend.Mappers;


import com.example.backend.DTOs.BuildDTO;
import com.example.backend.DTOs.BuildPartDTO;
import com.example.backend.DTOs.PartDTO;
import com.example.backend.Models.BuildPart;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BuildPartMapper {
    // Method to convert BuildPartDTO to BuildPart
    public static BuildPart toEntity(BuildPartDTO buildPartDTO) {
        if (buildPartDTO == null) {
            return null;
        }
        BuildPart buildPart = new BuildPart();
        buildPart.setId(UUID.fromString(buildPartDTO.getId()));
        buildPart.setBuildId(UUID.fromString(buildPartDTO.getBuildDto().getId()));
        buildPart.setPartId(UUID.fromString(buildPartDTO.getPartDto().getId()));
        return buildPart;
    }

    // Method to convert BuildPart to BuildPartDTO
    public static BuildPartDTO toDTO(BuildPart buildPart) {
        if (buildPart == null) {
            return null;
        }
        BuildPartDTO buildPartDTO = new BuildPartDTO();
        buildPartDTO.setId(buildPart.getId().toString());
        // Assuming you have methods to get the Build and Part DTOs
        BuildDTO buildDTO = new BuildDTO();
        buildDTO.setId(buildPart.getBuildId().toString());
        buildPartDTO.setBuildDto(buildDTO);

        PartDTO partDTO = new PartDTO();
        partDTO.setId(buildPart.getPartId().toString());
        buildPartDTO.setPartDto(partDTO);
        return buildPartDTO;
    }

    // Method to convert a list of BuildPartDTOs to a list of BuildParts
    public static List<BuildPart> toEntityList(List<BuildPartDTO> buildPartDTOs) {
        if (buildPartDTOs == null) {
            return new ArrayList<>();
        }
        return buildPartDTOs.stream()
                .map(BuildPartMapper::toEntity)
                .toList();
    }

    // Method to convert a list of BuildParts to a list of BuildPartDTOs
    public static List<BuildPartDTO> toDTOList(List<BuildPart> buildParts) {
        if (buildParts == null) {
            return new ArrayList<>();
        }
        return buildParts.stream()
                .map(BuildPartMapper::toDTO)
                .toList();
    }
}
