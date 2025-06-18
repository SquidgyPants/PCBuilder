package com.example.backend.Repositories;

import com.example.backend.DTOs.PartDTO;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildPart extends CrudRepository<PartDTO, String> {
    @Query("SELECT new PartDTO(p.id, p.name, p.price, p.type, p.compatibility) FROM BuildPart bp, PartDTO p where bp.id = p.id and bp.id = ?1")
    List<PartDTO> findPartsByBuildId(String buildId);
}
