package com.example.backend.Controllers;

import com.example.backend.Containers.PartContainer;
import com.example.backend.Models.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    private PartContainer partService;

    @Autowired
    public PartController(PartContainer partService) {
        this.partService = partService;
    }

    @PostMapping
    public ResponseEntity<Part> createPart(@RequestBody Part part) {
        return ResponseEntity.ok(partService.createPart(part));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> getPart(@PathVariable UUID id) {
        return ResponseEntity.ok(partService.getPartById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@RequestBody Part part) {
        return ResponseEntity.ok(partService.updatePart(part));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePart(@PathVariable UUID id) {
        partService.deletePart(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Part>> getAllParts() {
        return ResponseEntity.ok((List<Part>) partService.getAllParts());
    }
}


