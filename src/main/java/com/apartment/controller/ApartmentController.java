package com.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.service.ApartmentService;
import com.apartment.entities.Apartment;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class ApartmentController {

	@Autowired
	private ApartmentService apartmentService;

	@PostMapping("/")
	public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apatment) {
		Apartment createApartment = apartmentService.createApartment(apatment);
		return new ResponseEntity<>(createApartment, HttpStatus.CREATED);

	}

	@GetMapping("/getAllApartments")
	public ResponseEntity<List<Apartment>> getAllApartment() {
		List<Apartment> allApartment = apartmentService.getAllApartment();
		return new ResponseEntity<>(allApartment, HttpStatus.OK);
	}

	@GetMapping("/getApartmentById/{id}")
	public ResponseEntity<Apartment> getApartmentById(@PathVariable("id") Integer id) {
		Apartment apartmentById = apartmentService.getApartmentById(id);
		return new ResponseEntity<>(apartmentById, HttpStatus.OK);

	}

	@PutMapping("/upadteApartment/{id}")
	public ResponseEntity<Apartment> updateApartmentById(@RequestBody Apartment apartment, @PathVariable("id") Integer id) {
		Apartment updateApartment = apartmentService.updateApartment(apartment, id);
		return new ResponseEntity<>(updateApartment, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteApartmentbyId/{id}")
	public ResponseEntity<String> deleteApartmentById(@PathVariable("id") Integer id){
		apartmentService.deleteApartmentById(id);
		return new ResponseEntity<>("Apartment Deleted Successfully", HttpStatus.OK);
	}

}
