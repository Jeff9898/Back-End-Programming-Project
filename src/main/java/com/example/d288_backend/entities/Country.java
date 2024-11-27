package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long id;

    @Column(name = "country", nullable = true)
    private String name;

    @Column(name = "create_date", nullable = true)
    private java.time.LocalDateTime createDate;

    @Column(name = "last_update", nullable = true)
    private java.time.LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "country")
    private java.util.List<Division> divisions;
}

