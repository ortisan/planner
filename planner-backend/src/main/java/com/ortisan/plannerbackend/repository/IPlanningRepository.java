package com.ortisan.plannerbackend.repository;

import com.ortisan.plannerbackend.model.Planning;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface IPlanningRepository extends MongoRepository<Planning, UUID> {
    @Query(value = "{squad:'?0'}", fields = "{'squad' : 1, 'items' : 1}")
    Planning findBySquad(String squad);

    @Query(value = "{_id:'?0'}", fields = "{'squad' : 1, 'items' : 1}")
    Optional<Planning> findById(UUID id);

}
