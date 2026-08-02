package org.example.agrify.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id", nullable = false, updatable = false)
    private UUID customerId;

    @NotBlank(message = "Customer name is required")
    @Column(nullable = false)
    private String customerName;

    @Email(message = "Invalid email")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;
}