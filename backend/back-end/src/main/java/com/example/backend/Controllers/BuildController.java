package com.example.backend.Controllers;

import com.example.backend.Containers.BuildContainer;
import com.example.backend.DTOs.BuildDTO;
import com.example.backend.Models.Build;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/builds")
public class BuildController {

    @Autowired
    private BuildContainer buildService;

    @PostMapping
    public ResponseEntity<Build> createBuild(@RequestBody BuildDTO buildDTO) {
        return ResponseEntity.ok(buildService.createBuild(buildDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Build> getBuild(@PathVariable UUID id) {
        return ResponseEntity.ok(buildService.getBuild(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Build> updateBuild(@RequestBody BuildDTO buildDTO) {
        return ResponseEntity.ok(buildService.updateBuild(buildDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuild(@PathVariable UUID id) {
        buildService.deleteBuild(id);
        return ResponseEntity.noContent().build();
    }
}

