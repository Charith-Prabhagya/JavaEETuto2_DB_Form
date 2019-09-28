package com.thinktank;
import java.io.Serializable;

//NEW Add street, city, state, zipcode, email, password

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String email;
	private String password;
	private String phone;
	
	public Customer() {
		this.fName = "";
		this.lName = "";
		this.street = "";
		this.city = "";
		this.state = "";
		this.zipcode = "";
		this.email = "";
		this.password = "";
		this.phone = "";
	}
	
	public Customer(String fName, String lName, String street,
			String city, String state, String zipcode,
			String email, String password, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setZipcode(zipcode);
		this.setEmail(email);
		this.setPassword(password);
		this.phone = phone;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}