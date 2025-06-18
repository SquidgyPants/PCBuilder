package com.example.backend.Models;

import com.example.backend.Enums.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Part {


    private UUID id;
    private String name;
    private Double price;
    private Type type;
    private String compatibility;

    private String typeName;
}

