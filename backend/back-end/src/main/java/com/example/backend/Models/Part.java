package com.example.backend.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Part {


    private UUID id;
    private String name;
    private Double price;
    private String type;
    private String compatibility;
}

