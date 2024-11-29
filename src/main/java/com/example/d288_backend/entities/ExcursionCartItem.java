package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "excursion_cartitem")
@Getter
@Setter
public class ExcursionCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "excursion_id", referencedColumnName = "excursion_id", nullable = false)
    private Excursion excursion;

    @ManyToOne
    @JoinColumn(name = "cart_item_id", referencedColumnName = "cart_item_id", nullable = false)
    private CartItem cartItem;
}



