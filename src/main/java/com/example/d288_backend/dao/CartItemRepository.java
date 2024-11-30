package com.example.d288_backend.dao;

import com.example.d288_backend.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
