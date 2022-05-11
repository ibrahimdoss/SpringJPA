package com.JPA.JavaPersistanceAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.JavaPersistanceAPI.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}

//Generic icinde ilk kısım class'ın ismi 
//ikinci kısım ise entity icindeki PK'nın veri tipi.
