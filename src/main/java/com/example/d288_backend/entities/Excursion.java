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

    @Column(name = "excursion_title", nullable = true)
    private String excursionTitle;

    @Column(name = "excursion_price", nullable = true, precision = 19, scale = 2)
    private BigDecimal excursionPrice;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @Column(name = "last_update", nullable = true)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "vacation_id", referencedColumnName = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();
}



