package com.example.backend.Mappers;

import com.example.backend.DTOs.BuildDTO;
import com.example.backend.Models.Build;
import com.example.backend.Models.Part;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Component
public class BuildMapper {

    public static BuildDTO toDTO(Build build) {
        if (build == null) return null;

        BuildDTO dto = new BuildDTO();
        dto.setId(build.getId().toString());
        dto.setName(build.getName());
        dto.setPrice(build.getPrice());
        dto.setCreator(build.getCreator());
        return dto;
    }

    public static Build toEntity(BuildDTO dto) {
        if (dto == null) return null;
        List<Part> parts = new ArrayList<>();

        Build build = new Build();
        build.setId(UUID.fromString(dto.getId()));
        build.setName(dto.getName());
        build.setPrice(dto.getPrice());
        build.setCreator(dto.getCreator());
        build.setParts(parts);
        return build;
    }

    public static Iterable<BuildDTO> toDTOIterable(Iterable<Build> builds) {
        Iterable<BuildDTO> result = new ArrayList<>();
        for (Build build : builds) {
            ((Collection<BuildDTO>) result).add(toDTO(build));
        }
        return result;
    }

    public static Iterable<Build> toEntityIterable(Iterable<BuildDTO> dtos) {
        Iterable<Build> result = new ArrayList<>();
        for (BuildDTO dto : dtos) {
            ((Collection<Build>) result).add(toEntity(dto));
        }
        return result;
    }
}

