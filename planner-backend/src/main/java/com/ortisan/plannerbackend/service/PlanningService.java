package com.ortisan.plannerbackend.service;

import com.ortisan.plannerbackend.model.Planning;
import com.ortisan.plannerbackend.model.PlanningItem;
import com.ortisan.plannerbackend.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanningService implements IPlanningService {

    @Autowired
    private PlanningRepository planningRepository;


    @Override
    public Planning add(Planning planning) {
        UUID id = UUID.randomUUID();
        planning.setId(id);
        Planning insert = planningRepository.save(planning);
        return insert;
    }

    @Override
    public Planning update(Planning planning) {
        return planningRepository.save(planning);
    }

    @Override
    public Planning getBySquad(String squad) {
        return planningRepository.findBySquad(squad);
    }

    @Override
    public Planning add(PlanningItem planningItem) {
        planningItem.setPlanningId(UUID.randomUUID());
        return planningRepository.addItem(planningItem);
    }

    @Override
    public PlanningItem update(PlanningItem planningItem) {
        return null;
    }

    @Override
    public List<PlanningItem> getItemsByPlanning(UUID planningId) {
        return null;
    }

//    @Override
//    public PlanningItem add(PlanningItem planningItem) {
//        UUID id = UUID.randomUUID();
//        planningItem.setId(id);
//        return planningItemRepository.save(planningItem);
//    }
//
//    @Override
//    public PlanningItem update(PlanningItem planningItem) {
//        return planningItemRepository.save(planningItem);
//    }
//
//    @Override
//    public List<PlanningItem> getItemsByPlanning(UUID planningId) {
//        return planningItemRepository.findByPlanning(planningId);
//    }
}
