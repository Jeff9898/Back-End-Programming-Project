package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "postal_code", nullable = true)
    private String postalCode;

    @Column(name = "customer_first_name", nullable = true)
    private String firstName;

    @Column(name = "customer_last_name", nullable = true)
    private String lastName;  // Matches `lastName` from TypeScript

    @Column(name = "phone", nullable = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = true)
    private Division division;
}

