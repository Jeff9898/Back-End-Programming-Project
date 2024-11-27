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

    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @Column(name = "last_update", nullable = true)
    private LocalDateTime lastUpdate;

    @Column(name = "travel_fare_price", nullable = true, precision = 19, scale = 2)
    private BigDecimal travelFarePrice;

    @Column(name = "vacation_title", nullable = true)
    private String vacationTitle;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private List<Excursion> excursions;

}

