package com.example.backend.DTOs;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "build_part")
@Getter
@Setter
public class BuildPartDTO {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "build_id")
    private BuildDTO buildDto;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private PartDTO partDto;
}
