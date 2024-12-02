package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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

    @Column(name = "division", nullable = false)
    private String division_name;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", insertable = false, updatable = false, nullable = false)
    private Country country;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customers;

    //Fix for the front-end not populating division
    @Column(name = "country_id")
    private Long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }
}


