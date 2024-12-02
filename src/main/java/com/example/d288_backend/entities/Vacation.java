package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vacations")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id", nullable = false)
    private Long id;

    @Column(name = "vacation_title", nullable = false)
    private String vacation_title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "travel_fare_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal travel_price;

    @Column(name = "image_url", nullable = false)
    private String image_URL;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime create_date;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime last_update;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private List<Excursion> excursions;
}


