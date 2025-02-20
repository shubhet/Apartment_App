package com.apartment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="apartment")
public class Apartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int apartment_Id;
	
	@Column
	private String apartment_Name;
	
	@Column
	private int apartment_bhkType;
	
	@Column
	private int apartment_noOfFloor;
	

}
