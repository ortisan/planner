package com.ortisan.plannerbackend.service;

import com.ortisan.plannerbackend.repository.IPlanningItemRepository;
import com.ortisan.plannerbackend.repository.document.PlanningItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanningService implements IPlanningService {

    @Autowired
    private IPlanningItemRepository planningItemRepository;

    @Override
    public PlanningItem addItem(PlanningItem planningItem) {
        UUID id = UUID.randomUUID();
        planningItem.setId(id);
        PlanningItem insert = planningItemRepository.insert(planningItem);
        return insert;
    }

    @Override
    public PlanningItem editItem(PlanningItem planningItem) {
        return planningItemRepository.save(planningItem);
    }

    @Override
    public List<PlanningItem> getBySquad(String squad) {
        return planningItemRepository.findBySquad(squad);
    }

}
