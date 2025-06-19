package com.example.backend.DTOs;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "build_part")
@Getter
@Setter
public class BuildPart {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "build_id")
    private BuildDTO build;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private PartDTO part;
}
