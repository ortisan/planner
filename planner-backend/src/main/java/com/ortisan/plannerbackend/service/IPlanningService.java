package com.ortisan.plannerbackend.service;

import com.ortisan.plannerbackend.model.Planning;
import com.ortisan.plannerbackend.model.PlanningItem;

import java.util.List;
import java.util.UUID;

public interface IPlanningService {

    Planning add(Planning planningItem);

    Planning update(Planning planningItem);

    Planning getBySquad(String squad);

    Planning add(PlanningItem planningItem);

    PlanningItem update(PlanningItem planningItem);

    List<PlanningItem> getItemsByPlanning(UUID planningId);

}
