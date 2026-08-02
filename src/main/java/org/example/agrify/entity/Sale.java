package org.example.agrify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.agrify.enums.PaymentMethod;
import org.example.agrify.enums.Unit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sale_id", nullable = false, updatable = false)
    private UUID saleId;

    @NotNull(message = "Sale date is required")
    @Column(nullable = false)
    private LocalDate saleDate;

    @NotNull(message = "Quantity sold is required")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantitySold;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Unit unit;

    @NotNull(message = "Unit price is required")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @NotNull(message = "Total amount is required")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "harvest_id", nullable = false)
    private Harvest harvest;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}