package com.example.backend.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.backend.Enums.Type;

@Entity
@Table(name = "partdto")
@Getter
@Setter
public class PartDTO {
    @Id
    private String id;
    private String name;
    private Double price;
    private Type type;
    private String compatibility;

    public PartDTO() {

    }

    public PartDTO(String id, String name, Double price, Type type, String compatibility) {
        // Constructor needed for JPA
    }
}

