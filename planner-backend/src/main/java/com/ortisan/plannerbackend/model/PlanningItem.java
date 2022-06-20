package com.ortisan.plannerbackend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ortisan.plannerbackend.json.serializers.ObjectIdSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class PlanningItem extends BaseModel {
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId planningId;
    private String epic;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<UUID> dependents;
}
