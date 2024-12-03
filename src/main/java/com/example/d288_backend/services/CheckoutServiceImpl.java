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
    public PurchaseResponse placeOrder(Purchase purchase) {
        //Retrieve cart information
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        String orderTrackingNumber = generateOrderTrackingNumber();

        //Populate the cart with cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.add(item);
        });

        //Check if cart is empty
        if(cart.getCartItems().isEmpty()) {
            orderTrackingNumber = "Error - Add items to cart before checking out";
        } else {

            //Generate tracking number, and set status to 'ordered'
            cart.setOrderTrackingNumber(orderTrackingNumber);
            cart.setStatus(StatusType.ordered);
            cart.setCustomer(customer);

            //Save data
            cartRepository.save(cart);
        }

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }

}
