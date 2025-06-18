package com.example.backend.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partdto")
@Getter
@Setter
public class PartDTO {
    @Id
    private String id;
    private String name;
    private Double price;
    private String type;
    private String compatibility;

    public PartDTO() {

    }

    public PartDTO(String id, String name, Double price, String type, String compatibility) {
        // Constructor needed for JPA
    }
}

