package com.example.d288_backend.services;

import com.example.d288_backend.entities.Cart;
import com.example.d288_backend.entities.CartItem;
import com.example.d288_backend.entities.Customer;
import com.example.d288_backend.entities.StatusType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
    private StatusType status;
}
