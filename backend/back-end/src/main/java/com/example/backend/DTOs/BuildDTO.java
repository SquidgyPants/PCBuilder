package com.example.backend.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class BuildDTO {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Double price;
    private String creator;
}
