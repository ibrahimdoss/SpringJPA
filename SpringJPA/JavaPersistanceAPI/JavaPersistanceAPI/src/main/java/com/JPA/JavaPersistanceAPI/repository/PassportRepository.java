package com.JPA.JavaPersistanceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.JavaPersistanceAPI.models.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer>{

}
