package com.ortisan.plannerbackend.repository;

import com.mongodb.client.result.UpdateResult;
import com.ortisan.plannerbackend.model.Planning;
import com.ortisan.plannerbackend.model.PlanningItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PlanningRepository {

    @Autowired
    private IPlanningRepository planningRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Transactional
    public Planning addItem(PlanningItem planningItem) {
        final Query query = new Query(
                Criteria.where("_id").is(planningItem.getPlanningId())
        );
        final Update update = new Update().addToSet("items", planningItem);
        UpdateResult updateResult = mongoOperations.updateFirst(query, update, Planning.class);
        return planningRepository.findById(planningItem.getPlanningId()).get();
    }

    public Planning save(Planning planning) {
        return planningRepository.save(planning);
    }

    public Planning findBySquad(String squad) {
        return planningRepository.findBySquad(squad);
    }
}
