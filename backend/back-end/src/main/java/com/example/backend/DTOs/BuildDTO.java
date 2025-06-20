package com.example.backend.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "builddto")
@Getter
@Setter
public class BuildDTO {
    @Id
    private String id;
    private String name;
    private Double price;
    private String creator;


}
