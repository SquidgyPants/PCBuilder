package com.example.backend.Containers;

import com.example.backend.DTOs.BuildDTO;
import com.example.backend.Mappers.BuildMapper;
import com.example.backend.Mappers.PartMapper;
import com.example.backend.Models.Build;
import com.example.backend.Models.Part;
import com.example.backend.Repositories.BuildInterface;
import com.example.backend.Repositories.BuildPart;
import com.example.backend.Repositories.PartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BuildContainer {

    private final BuildInterface repo;
    private final BuildPart buildPart;

    @Autowired
    public BuildContainer(BuildInterface repo, BuildPart buildPart) {
        this.repo = repo;
        this.buildPart = buildPart;
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

        Build buildmodel = BuildMapper.toEntity(build);
        buildmodel.setParts(new ArrayList<>());
        for (Part p : buildmodel.getParts()) {
            addToPrice(buildmodel, p);
        }
        return BuildMapper.toEntity(build);
    }

    public Build updateBuild(BuildDTO dto) {
        return BuildMapper.toEntity(repo.save(dto));
    }

    public void deleteBuild(UUID id) {
        repo.deleteById(id.toString());
    }

    public void addToPrice(Build build, Part part) {
        Double price = build.getPrice();
        price += part.getPrice();
    }
}

