package com.ortisan.plannerbackend.model;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "squads")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Squad extends BaseModel {
    @Id
    private UUID id;
    private String name;
}
