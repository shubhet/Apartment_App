package com.apartment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.entities.Apartment;
import com.apartment.repository.ApartmentRepository;
import com.apartment.service.ApartmentService;

@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Override
	public Apartment createApartment(Apartment apartment) {
		Apartment createApartment = this.apartmentRepository.save(apartment);
		return createApartment;
	}

	@Override
	public Apartment updateApartment(Apartment apartment, Integer apartmentId) {

		Apartment apartmentById = apartmentRepository.findById(apartmentId).orElseThrow();
		apartmentById.setApartment_Name(apartment.getApartment_Name());
		apartmentById.setApartment_bhkType(apartment.getApartment_bhkType());
		apartmentById.setApartment_noOfFloor(apartment.getApartment_noOfFloor());
		Apartment updatedApartment = apartmentRepository.save(apartmentById);
		return updatedApartment;

	}

	@Override
	public List<Apartment> getAllApartment() {
		List<Apartment> allApartment = this.apartmentRepository.findAll();
		return allApartment;
	}

	@Override
	public void deleteApartmentById(Integer apartment_id) {
		Apartment apartement = this.apartmentRepository.findById(apartment_id).orElseThrow();
		apartmentRepository.delete(apartement);
	}

	@Override
	public Apartment getApartmentById(Integer apartment_id) {
		Apartment apartmentById = this.apartmentRepository.findById(apartment_id).orElseThrow();
		return apartmentById;

	}

}
