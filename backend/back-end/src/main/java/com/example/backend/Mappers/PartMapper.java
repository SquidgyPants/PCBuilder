package com.example.backend.Mappers;

import com.example.backend.DTOs.PartDTO;
import com.example.backend.Models.Part;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PartMapper {

    public static PartDTO toDTO(Part part) {
        if (part == null) return null;

        PartDTO dto = new PartDTO();
        dto.setId(part.getId().toString());
        dto.setName(part.getName());
        dto.setPrice(part.getPrice());
        dto.setType(part.getType());
        dto.setCompatibility(part.getCompatibility());
        return dto;
    }

    public static Part toEntity(PartDTO dto) {
        if (dto == null) return null;

        Part part = new Part();
        part.setId(UUID.fromString(dto.getId()));
        part.setName(dto.getName());
        part.setPrice(dto.getPrice());
        part.setType(dto.getType());
        part.setCompatibility(dto.getCompatibility());
        return part;
    }

    public static List<PartDTO> toDTOList(Iterable<Part> parts) {
        List<PartDTO> result = new ArrayList<>();
        for (Part part : parts) {
            result.add(toDTO(part));
        }
        return result;
    }

    public static List<Part> toEntityList(Iterable<PartDTO> dtos) {
        List<Part> result = new ArrayList<>();
        for (PartDTO dto : dtos) {
            result.add(toEntity(dto));
        }
        return result;
    }
}



