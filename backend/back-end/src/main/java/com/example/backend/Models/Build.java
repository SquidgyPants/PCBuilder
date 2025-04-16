package com.example.backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Build {
    private UUID id;
    private String name;
    private Double price;
    private String creator;

    @ManyToMany(mappedBy="builds")
    @JoinTable(name = "build_parts",
            joinColumns = @JoinColumn(name = "build_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id"))
    private Iterable<Part> parts;
}

