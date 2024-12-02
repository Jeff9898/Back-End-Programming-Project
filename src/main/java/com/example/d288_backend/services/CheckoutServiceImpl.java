package com.example.d288_backend.services;

import com.example.d288_backend.dao.CartItemRepository;
import com.example.d288_backend.dao.CustomerRepository;
import com.example.d288_backend.dao.CartRepository;
import com.example.d288_backend.entities.Cart;
import com.example.d288_backend.entities.CartItem;
import com.example.d288_backend.entities.Customer;
import com.example.d288_backend.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl (CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder (Purchase purchase) {

        // Retrieve purchase data
        Cart cart = purchase.getCart();

        // Check if cart is empty, cartItems is null, or cartItems is empty
        if (cart == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()) {
            return new PurchaseResponse("Error - Order can not be placed with an empty cart.");
        }

        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();

        // Generate order tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Set status of the cart
        cart.setStatus(StatusType.ordered);

        // Add each CartItem to the Cart
        cartItems.forEach (cartItem -> {
            cartItem.setCart(cart); // Associate CartItem with Cart
            cartItemRepository.save(cartItem);
                });

        // Associate the cart with the customer
        customer.addCart(cart);
        customerRepository.save(customer);

        // Save the cart
        cartRepository.save(cart);

        // Return the PurchaseResponse
        return new PurchaseResponse(orderTrackingNumber);
        }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }

}
