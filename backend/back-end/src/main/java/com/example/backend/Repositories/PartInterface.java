package com.example.backend.Repositories;

import com.example.backend.DTOs.PartDTO;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Table
public interface PartInterface extends CrudRepository<PartDTO, UUID> {

}
