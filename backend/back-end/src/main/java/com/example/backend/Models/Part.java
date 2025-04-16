package com.example.backend.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Part {


    private UUID id;
    private String name;
    private Double price;
    private String type;
    private String compatibility;

    @ManyToMany(mappedBy = "parts")
    private List<Build> builds;

    public void setUUID() {
        this.id = UUID.randomUUID();
    }
}

