package com.ortisan.plannerbackend.controller;

import com.ortisan.plannerbackend.model.Planning;
import com.ortisan.plannerbackend.model.PlanningItem;
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

    @PostMapping("/plannings")
    public ResponseEntity insert(@RequestBody Planning planning) {
        Planning inserted = planningService.add(planning);
        return ResponseEntity.of(Optional.of(inserted));
    }

    @GetMapping("/plannings")
    public ResponseEntity getPlanningItems(@RequestParam(required = true) String filter, @RequestParam(required = true) String value) {
        Planning planning = planningService.getBySquad(value);
        return ResponseEntity.of(Optional.of(planning));
    }

    @PostMapping("/plannings/{planningId}/planning-items")
    public ResponseEntity insertItem(@PathVariable("planningId") String planningId, @RequestBody PlanningItem planningItem) {
        planningItem.setPlanningId(UUID.fromString(planningId));
        Planning inserted = planningService.add(planningItem);
        return ResponseEntity.of(Optional.of(inserted));
    }

    @GetMapping("/plannings/{planningId}/planning-items")
    public ResponseEntity getPlanningItems(@PathVariable("planningId") String planningIdStr, @RequestParam(required = true) String filter, @RequestParam(required = true) String value) {
        UUID planningId = UUID.fromString(planningIdStr);
        List<PlanningItem> itemsBySquad = planningService.getItemsByPlanning(planningId);
        return ResponseEntity.of(Optional.of(itemsBySquad));
    }

    @PatchMapping("/plannings/{planningId}/planning-items/{id}")
    public ResponseEntity updateItem(@PathVariable("planningId") String planningId, @PathVariable("id") String id, @RequestBody PlanningItem planningItem) {
        planningItem.setPlanningId(UUID.fromString(planningId));
        planningItem.setId(UUID.fromString(id));
        Planning updated = planningService.add(planningItem);
        return ResponseEntity.of(Optional.of(updated));
    }
}
