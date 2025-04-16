package com.example.backend.Repositories;

import com.example.backend.DTOs.BuildDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildInterface extends CrudRepository<BuildDTO, UUID> {
}
