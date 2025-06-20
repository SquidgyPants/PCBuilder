package com.example.backend.Repositories;

import com.example.backend.DTOs.BuildPartDTO;
import com.example.backend.DTOs.PartDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildPartInterface extends CrudRepository<BuildPartDTO, String> {
    @Query(value = "SELECT new PartDTO(p.id, p.name, p.price, p.type, p.compatibility) FROM BuildPartDTO bp JOIN bp.partDto p WHERE bp.buildDto.id = ?1")
    List<PartDTO> findPartsByBuildId(String buildId);
}
