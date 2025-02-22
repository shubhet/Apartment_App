package com.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.entities.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer>{

}
