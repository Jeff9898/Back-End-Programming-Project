package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private Long id;

    @Column(name = "division", nullable = true)
    private String division_name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "division")
    private List<Customer> customers;
}


