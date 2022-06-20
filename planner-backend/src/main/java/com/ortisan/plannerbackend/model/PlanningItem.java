package com.ortisan.plannerbackend.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class PlanningItem extends BaseModel {
    @Id
    private UUID id;
    private UUID planningId;
    private String epic;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<UUID> dependents;
}
