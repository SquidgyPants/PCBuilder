package com.example.backend.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "builddto")
@Getter
@Setter
public class BuildDTO {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private Double price;
    private String creator;
}
