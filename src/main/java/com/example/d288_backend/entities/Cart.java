package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Long id;

    @Column(name = "package_price", nullable = true, precision = 19, scale = 2)
    private BigDecimal packagePrice;

    @Column(name = "party_size", nullable = true)
    private Integer partySize;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = true)
    private StatusType status;

    @Column(name = "order_tracking_number", nullable = true)
    private String orderTrackingNumber;

    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @Column(name = "last_update", nullable = true)
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;

}



