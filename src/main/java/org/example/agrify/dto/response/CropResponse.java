package org.example.agrify.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropResponse {

    private UUID cropId;
    private String cropName;
    private String cropType;
    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;
    private String growthStatus;
    private UUID farmId;
}