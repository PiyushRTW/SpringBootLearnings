package com.Learning.Let.sLearn.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TrainDTO {
    private Long id;
    private String trainNumber;
    private String name;
    private String sourceStation;
    private String destinationStation;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // Include other relevant train fields
}