package com.apartment.service;

import java.util.List;

import com.apartment.entities.Apartment;

public interface ApartmentService {
	
	Apartment createApartment(Apartment apartment);
	Apartment updateApartment(Apartment apartment, Integer apartmentId);
	List<Apartment> getAllApartment();
	Apartment getApartmentById(Integer apartment_id);
	void deleteApartmentById(Integer apartment_id);
	

}
