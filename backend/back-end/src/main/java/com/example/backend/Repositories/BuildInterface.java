package com.example.backend.Repositories;

import com.example.backend.DTOs.BuildDTO;
import jakarta.persistence.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Table
public interface BuildInterface extends CrudRepository<BuildDTO, String> {
}
