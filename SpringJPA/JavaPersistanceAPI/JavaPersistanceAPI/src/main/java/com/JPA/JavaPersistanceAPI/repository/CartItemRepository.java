package com.JPA.JavaPersistanceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.JavaPersistanceAPI.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

}
