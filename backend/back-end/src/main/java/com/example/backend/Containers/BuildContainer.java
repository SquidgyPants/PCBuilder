package com.example.backend.Containers;

import com.example.backend.DTOs.BuildDTO;
import com.example.backend.DTOs.BuildPartDTO;
import com.example.backend.DTOs.PartDTO;
import com.example.backend.Mappers.BuildMapper;
import com.example.backend.Mappers.BuildPartMapper;
import com.example.backend.Mappers.PartMapper;
import com.example.backend.Models.Build;
import com.example.backend.Models.BuildPart;
import com.example.backend.Models.Part;
import com.example.backend.Repositories.BuildInterface;
import com.example.backend.Repositories.BuildPartInterface;
import com.example.backend.Repositories.PartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
public class BuildContainer {

    private final BuildInterface repo;
    private final BuildPartInterface buildPart;
    private final PartInterface partRepo;

    @Autowired
    public BuildContainer(BuildInterface repo, BuildPartInterface buildPart, PartInterface partRepo) {
        this.repo = repo;
        this.buildPart = buildPart;
        this.partRepo = partRepo;
    }

    public Build createBuild(BuildDTO dto) {
        return BuildMapper.toEntity(repo.save(dto));
    }

    public Build getBuild(UUID id) {
        BuildDTO builddto = repo.findById(id.toString())
                .orElse(new BuildDTO());
        List<Part> parts = PartMapper.toEntityList(buildPart.findPartsByBuildId(id.toString()));
        Build build = BuildMapper.toEntity(builddto);
        build.setParts(parts);
        return build;
    }

    public Build getNewBuild() {
        BuildDTO build = new BuildDTO();
        build.setId(UUID.randomUUID().toString());
        build = repo.save(build);

        Build buildModel = BuildMapper.toEntity(build);
        buildModel.setParts(new ArrayList<>());
        List<PartDTO> partDTOs = StreamSupport.stream(partRepo.findAll().spliterator(), false)
                .collect(Collectors.groupingBy(
                        PartDTO::getType,
                        toList()
                ))
                .values()
                .stream()
                .flatMap(List::stream)
                .toList();
        List<Part> parts = partDTOs.stream()
                .map(PartMapper::toEntity)
                .toList();

        buildModel.setAllParts(parts);
        return buildModel;
    }

    public Build updateBuild(Build build) {
        BuildDTO buildDTO = BuildMapper.toDTO(build);

        for (BuildPart bp : build.getBuildParts()) {
            if (bp.getBuildId() != null) {
                BuildPartDTO buildPartDTO = BuildPartMapper.toDto(bp);
                buildPartDTO.setId(UUID.randomUUID().toString());
                buildPartDTO.setBuildDTO(buildDTO);
                buildPartDTO.setPartDTO(PartMapper.toDTO(build.getPartToAdd()));
                buildPart.save(buildPartDTO);
            } else {
                throw new IllegalArgumentException("BuildPart must have a valid buildId");
            }
        }
        for (Part part : build.getAllParts()) {
            if (part.getType() == build.getPartToAdd().getType()) {
                build.getAllParts().remove(part);
            }
        }

        return BuildMapper.toEntity(repo.save(buildDTO));
//        if (build.getId() == null || build.getId().isEmpty()) {
//            throw new IllegalArgumentException("Build cannot be null or empty");
//        }
//        build.getParts().add(build.getPartToAdd());
//        for (Part part : build.getParts()) {
//            if (part.getId() == null || part.getId().isEmpty()) {
//                throw new IllegalArgumentException("Part cannot be null or empty");
//            }
//        }
//        buildPart.addPartsToBuild(build.getId().toString(), build.getPartToAdd().getId().toString());
//        return BuildMapper.toEntity(repo.save(build));
    }

    public void deleteBuild(UUID id) {
        repo.deleteById(id.toString());
    }
}

