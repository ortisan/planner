package com.ortisan.plannerbackend.service;

import com.ortisan.plannerbackend.repository.document.PlanningItem;

import java.util.List;

public interface IPlanningService {

    PlanningItem addItem(PlanningItem planningItem);
    PlanningItem editItem(PlanningItem planningItem);
    List<PlanningItem> getBySquad(String squad);

}
