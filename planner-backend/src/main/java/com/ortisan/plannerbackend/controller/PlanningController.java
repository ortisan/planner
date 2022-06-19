package com.ortisan.plannerbackend.controller;

import com.ortisan.plannerbackend.repository.document.PlanningItem;
import com.ortisan.plannerbackend.service.IPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PlanningController {

    @Autowired
    private IPlanningService planningService;

    @PostMapping("/plannings/planning-items")
    public ResponseEntity insertItem(@RequestBody PlanningItem planningItem) {
        PlanningItem inserted = planningService.addItem(planningItem);
        return ResponseEntity.of(Optional.of(inserted));
    }

    @GetMapping("/plannings/planning-items")
    public ResponseEntity getPlanningItems(@RequestParam(required = true) String filter, @RequestParam(required = true) String value) {
        List<PlanningItem> itemsBySquad = planningService.getBySquad(value);
        return ResponseEntity.of(Optional.of(itemsBySquad));
    }

    @PatchMapping("/plannings/planning-items/{id}")
    public ResponseEntity updateItem(@PathVariable("id") String id, @RequestBody PlanningItem planningItem) {
        planningItem.setId(UUID.fromString(id));
        PlanningItem updated = planningService.editItem(planningItem);
        return ResponseEntity.of(Optional.of(updated));
    }
}
