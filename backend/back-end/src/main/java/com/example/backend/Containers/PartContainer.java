package com.example.backend.Containers;

import com.example.backend.DTOs.PartDTO;
import com.example.backend.Mappers.PartMapper;
import com.example.backend.Models.Part;
import com.example.backend.Repositories.PartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PartContainer {
    private final PartInterface repo;

    @Autowired
    public PartContainer(PartInterface repo) {
        this.repo = repo;
    }

    public Iterable<Part> getAllParts() {
        return PartMapper.toEntityList(repo.findAll());
    }

    public Part getPartById(UUID id) {
        return PartMapper.toEntity(repo.findById(id.toString()).orElse(null));
    }

    public Part createPart(Part part) {
        part.setId(UUID.randomUUID());
        return PartMapper.toEntity(repo.save(PartMapper.toDTO(part)));
    }

    public Part updatePart(Part part) {
        return PartMapper.toEntity(repo.save(PartMapper.toDTO(part)));
    }

    public void deletePart(UUID id) {
        try {
            repo.deleteById(id.toString());
        } catch (Exception e) {
            // Handle exception if needed
        }
    }
}
