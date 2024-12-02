package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();


    public void addCart(Cart cart) {
        carts.add(cart);
        cart.setCustomer(this);
    }
}

