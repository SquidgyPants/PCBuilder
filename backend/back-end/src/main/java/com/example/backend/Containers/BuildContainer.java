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

    public Build getBuild(String buildId) {
        BuildDTO builddto = repo.findById(buildId)
                .orElse(new BuildDTO());
        List<Part> parts = PartMapper.toEntityList(buildPart.findPartsByBuildId(buildId));
        Build build = BuildMapper.toEntity(builddto);
        build.setParts(parts);
        getBuildPrice(build);
        return build;
    }

    public List<Build> getAllBuilds() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(BuildMapper::toEntity)
                .toList();
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
        build.setParts(PartMapper.toEntityList(buildPart.findPartsByBuildId(build.getId().toString())));
        BuildDTO buildDTO = BuildMapper.toDTO(build);

        BuildPartDTO buildPartDTO = new BuildPartDTO();
        buildPartDTO.setId(UUID.randomUUID().toString());
        buildPartDTO.setBuildDto(buildDTO);
        buildPartDTO.setPartDto(PartMapper.toDTO(build.getPartToAdd()));
        buildPart.save(buildPartDTO);


        build.getAllParts().removeIf(
                part -> part.getType() == build.getPartToAdd().

                        getType()
        );

        repo.save(buildDTO);
        return build;
    }

    public void deleteBuild(UUID id) {
        repo.deleteById(id.toString());
    }

    public void getBuildPrice(Build build) {
        build.setPrice(0.0);
        for (Part part : build.getParts()) {
            build.setPrice(build.getPrice() + part.getPrice());
        }
    }
}

