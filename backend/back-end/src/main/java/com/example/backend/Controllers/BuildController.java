package com.example.backend.Controllers;

import com.example.backend.Containers.BuildContainer;
import com.example.backend.DTOs.BuildDTO;
import com.example.backend.Models.Build;
import com.example.backend.Models.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Build> getBuild(@RequestParam String id) {
        Build build = buildService.getBuild(id);
        if (build == null || build.getId() == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(build);
    }

    @GetMapping("/getAllBuilds")
    public ResponseEntity<List<Build>> getAllBuilds() {
        List<Build> builds = buildService.getAllBuilds();
        return ResponseEntity.ok(builds);
    }

    @GetMapping("/getNewBuild")
    public ResponseEntity<Build> getNewBuild() {
        Build build = buildService.getNewBuild();
        return ResponseEntity.ok(build);
    }

    @PutMapping("/updateBuild")
    public ResponseEntity<Build> updateBuild(@RequestBody Build build) {
        Build updatedBuild = buildService.updateBuild(build);
        if (updatedBuild.getId() == null) {
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(updatedBuild);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuild(@PathVariable UUID id) {
        buildService.deleteBuild(id);
        return ResponseEntity.noContent().build();
    }
}

