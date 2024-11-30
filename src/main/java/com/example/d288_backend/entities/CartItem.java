package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id", nullable = false)
    private Long id;

    @Column(name = "create_date", nullable = true)
    private LocalDateTime create_date;

    @Column(name = "last_update", nullable = true)
    private LocalDateTime last_update;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "vacation_id", referencedColumnName = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions = new HashSet<>();
}



