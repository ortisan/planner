package com.ortisan.plannerbackend.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "plannings")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Planning extends BaseModel {
    @Id
    private UUID id;
    private UUID squadId;
    private List<PlanningItem> items;
    private Boolean active;
}
