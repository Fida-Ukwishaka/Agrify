package org.example.agrify.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.GrowthStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropRequest {

    @NotBlank
    private String cropName;

    @NotBlank
    private String cropType;

    @NotNull
    private LocalDate plantingDate;

    @NotNull
    private LocalDate expectedHarvestDate;

    @NotNull
    private GrowthStatus growthStatus;

    @NotNull
    private UUID farmId;
}
