package com.ortisan.plannerbackend.repository;

import com.ortisan.plannerbackend.repository.document.PlanningItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IPlanningItemRepository extends MongoRepository<PlanningItem, UUID> {
    @Query(value = "{squad:'?0'}", fields = "{'squad' : 1, 'epic' : 1, 'dateStart' : 1, 'dateEnd' : 1}")
    List<PlanningItem> findBySquad(String squad);
}
