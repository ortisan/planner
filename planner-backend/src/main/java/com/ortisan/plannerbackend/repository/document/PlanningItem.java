package com.ortisan.plannerbackend.repository.document;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Document("plannignitems")
@Data
public class PlanningItem {

    @Id
    private UUID id;
    private String squad;
    private String epic;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
