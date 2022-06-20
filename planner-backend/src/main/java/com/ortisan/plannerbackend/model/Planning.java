package com.ortisan.plannerbackend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ortisan.plannerbackend.json.serializers.ObjectIdSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "plannings")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Planning extends BaseModel {
    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    @Indexed
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId squadId;
    private List<PlanningItem> items;
    private Boolean active;
}
