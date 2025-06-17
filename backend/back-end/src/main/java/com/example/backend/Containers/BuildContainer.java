package com.example.backend.Containers;

import com.example.backend.DTOs.BuildDTO;
import com.example.backend.Mappers.BuildMapper;
import com.example.backend.Models.Build;
import com.example.backend.Repositories.BuildInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildContainer {

    private final BuildInterface repo;

    @Autowired
    public BuildContainer(BuildInterface repo) {
        this.repo = repo;
    }

    public Build createBuild(BuildDTO dto) {
        return BuildMapper.toEntity(repo.save(dto));
    }

    public Build getBuild(UUID id) {
        Build build = repo.findById(id.toString())
                .map(BuildMapper::toEntity)
                .orElse(new Build());
        return build;
    }

    public Build getNewBuild() {
        BuildDTO build = new BuildDTO();
        build.setId(UUID.randomUUID().toString());
        build = repo.save(build);
        return BuildMapper.toEntity(build);
    }

    public Build updateBuild(BuildDTO dto) {
        return BuildMapper.toEntity(repo.save(dto));
    }

    public void deleteBuild(UUID id) {
        repo.deleteById(id.toString());
    }
}

