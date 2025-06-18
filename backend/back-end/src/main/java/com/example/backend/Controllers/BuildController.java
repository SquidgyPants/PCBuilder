package com.example.backend.Controllers;

import com.example.backend.Containers.BuildContainer;
import com.example.backend.DTOs.BuildDTO;
import com.example.backend.Models.Build;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/build")
public class BuildController {

    private BuildContainer buildService;

    @Autowired
    public BuildController(BuildContainer buildService) {
        this.buildService = buildService;
    }

    @PostMapping
    public ResponseEntity<Build> createBuild(@RequestBody BuildDTO buildDTO) {
        return ResponseEntity.ok(buildService.createBuild(buildDTO));
    }

    @GetMapping("/getBuild")
    public ResponseEntity<Build> getBuild(@PathVariable UUID id) {
        return ResponseEntity.ok(buildService.getBuild(id));
    }

    @GetMapping("/getNewBuild")
    public ResponseEntity<Build> getNewBuild() {
        Build build = buildService.getNewBuild();
        return ResponseEntity.ok(build);
    }

    @GetMapping("/addPartsToBuild")

    @PutMapping("/updateBuild")
    public ResponseEntity<Build> updateBuild(@RequestBody BuildDTO buildDTO) {
        return ResponseEntity.ok(buildService.updateBuild(buildDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuild(@PathVariable UUID id) {
        buildService.deleteBuild(id);
        return ResponseEntity.noContent().build();
    }
}

