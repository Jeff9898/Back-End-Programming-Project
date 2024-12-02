package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false)
    private Long id;

    @Column(name = "excursion_title", nullable = false)
    private String excursion_title;

    @Column(name = "excursion_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal excursion_price;

    @Column(name = "image_url", nullable = false)
    private String image_URL;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime create_date;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id", referencedColumnName = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();
}



