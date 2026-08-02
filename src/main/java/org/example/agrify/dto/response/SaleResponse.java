package org.example.agrify.dto.response;

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
public class SaleResponse {

    private UUID saleId;
    private LocalDate saleDate;
    private BigDecimal quantitySold;
    private Unit unit;
    private BigDecimal unitPrice;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private UUID harvestId;
    private UUID customerId;
}