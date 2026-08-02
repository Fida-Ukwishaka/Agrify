package org.example.agrify.dto.response;

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
public class FertilizerResponse {

    private UUID fertilizerId;
    private String fertilizerName;
    private FertilizerType fertilizerType;
    private Double quantityAvailable;
    private Unit unit;
    private LocalDate purchaseDate;
    private LocalDate expiryDate;
    private String supplier;
    private UUID farmId;
}
