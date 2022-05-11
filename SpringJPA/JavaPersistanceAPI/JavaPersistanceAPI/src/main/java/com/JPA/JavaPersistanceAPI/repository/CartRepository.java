package com.JPA.JavaPersistanceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.JavaPersistanceAPI.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
