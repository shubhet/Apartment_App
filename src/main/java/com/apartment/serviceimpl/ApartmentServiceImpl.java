package com.apartment.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.entities.Apartment;
import com.apartment.exception.ApartmentNotFountException;
import com.apartment.repository.ApartmentRepository;
import com.apartment.service.ApartmentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Override
	public Apartment createApartment(Apartment apartment) {
		Apartment createApartment = this.apartmentRepository.save(apartment);
		log.info("Saved Apartments details " + createApartment);
		return createApartment;
	}

	@Override
	public Apartment updateApartment(Apartment apartment, Integer apartmentId) {
		Optional<Apartment> apartmentById = this.apartmentRepository.findById(apartmentId);
		if (apartmentById.isEmpty()) {
			throw new ApartmentNotFountException();
		}
		Apartment fetchedApartment = apartmentById.get();
		fetchedApartment.setApartment_Name(apartment.getApartment_Name());
		fetchedApartment.setApartment_bhkType(apartment.getApartment_bhkType());
		fetchedApartment.setApartment_noOfFloor(apartment.getApartment_noOfFloor());
		Apartment updatedApartment = apartmentRepository.save(fetchedApartment);
		log.info("Updated Apartments details " + updatedApartment);
		return updatedApartment;

	}

	@Override
	public List<Apartment> getAllApartment() {
		List<Apartment> allApartment = this.apartmentRepository.findAll();
		log.info("All Apartments details " + allApartment);
		return allApartment;
	}

	@Override
	public void deleteApartmentById(Integer apartment_id) {
		Optional<Apartment> apartmentById = this.apartmentRepository.findById(apartment_id);
		if (apartmentById.isEmpty()) {
			throw new ApartmentNotFountException();
		}
		log.info("Deleted Apartments details " + apartmentById.get());
		apartmentRepository.delete(apartmentById.get());
	}

	@Override
	public Apartment getApartmentById(Integer apartment_id) {
		Optional<Apartment> apartmentById = this.apartmentRepository.findById(apartment_id);
		if (apartmentById.isEmpty()) {
			throw new ApartmentNotFountException();
		}
		log.info("Apartments details by Id " + apartmentById);
		return apartmentById.get();

	}

}
