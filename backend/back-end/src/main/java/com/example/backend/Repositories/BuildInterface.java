package com.example.backend.Repositories;

import com.example.backend.DTOs.BuildDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildInterface extends CrudRepository<BuildDTO, String> {
}
