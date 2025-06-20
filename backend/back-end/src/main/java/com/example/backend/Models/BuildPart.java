package com.example.backend.Models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BuildPart {
    @Id
    private UUID id;
    private UUID buildId;
    private UUID partId;

    public void setUUID() {
        this.id = UUID.randomUUID();
    }

}
