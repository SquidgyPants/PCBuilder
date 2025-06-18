package com.example.backend.Repositories;

import com.example.backend.DTOs.PartDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartInterface extends CrudRepository<PartDTO, String> {

}
