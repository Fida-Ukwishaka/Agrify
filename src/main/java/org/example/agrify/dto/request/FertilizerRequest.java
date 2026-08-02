package org.example.agrify.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.FertilizerType;
import org.example.agrify.enums.Unit;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FertilizerRequest {

    @NotBlank
    private String fertilizerName;

    @NotNull
    private FertilizerType fertilizerType;

    @NotNull
    private Double quantityAvailable;

    @NotNull
    private Unit unit;

    @NotNull
    private LocalDate purchaseDate;

    @Future
    private LocalDate expiryDate;

    @NotBlank
    private String supplier;

    @NotNull
    private UUID farmId;
}
