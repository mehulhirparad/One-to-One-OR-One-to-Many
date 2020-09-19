package com.hrms.system.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="emp_address")
public class EmployeeAddress
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_address_id")
	private int id;
	
	@NotNull(message="is required")	
	@Size(min=3,max=45,message="Minimum 3 character is requred")
	@Column(name="street")
	private String street;
	
	@NotNull(message="is required")	
	@Size(min=3,max=10,message="Minimum 3 character is requred")
	@Column(name="city")
	private String city;
	
	@NotNull(message="is required")	
	@Size(min=3,max=10,message="Minimum 3 character is requred")	
	@Column(name="state")
	private String state;
	
	@NotNull(message="is required")	
	@Size(min=3,max=10,message="Minimum 3 character is requred")	
	@Column(name="country")
	private String country;
	
	// Default constructor
	public EmployeeAddress() {
		
	}
	// Parameterize Constructor
	public EmployeeAddress(String street, String city, String state, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	// Getter / Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	// toString method
	@Override
	public String toString() {
		return "EmployeeAddress [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
		
	
	
}
