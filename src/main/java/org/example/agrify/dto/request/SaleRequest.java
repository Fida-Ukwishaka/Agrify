package org.example.agrify.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.PaymentMethod;
import org.example.agrify.enums.Unit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleRequest {

    @NotNull
    private LocalDate saleDate;

    @NotNull
    private BigDecimal quantitySold;

    @NotNull
    private Unit unit;

    @NotNull
    private BigDecimal unitPrice;

    @NotNull
    private BigDecimal totalAmount;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private UUID harvestId;

    @NotNull
    private UUID customerId;
}