package com.example.d288_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
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

    @Column(name = "package_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal package_price;

    @Column(name = "party_size", nullable = false)
    private Integer party_size;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusType status;

    @Column(name = "order_tracking_number", nullable = false)
    private String orderTrackingNumber;

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "last_update")
    private LocalDateTime last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;


    public void addCartItem(CartItem cartItem) {
        if (cartItems == null) {
            cartItems = new HashSet<>();
        }
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

}



