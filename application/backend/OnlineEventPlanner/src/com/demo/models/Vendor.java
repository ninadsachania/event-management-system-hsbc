package com.demo.models;

public class Vendor {
	private int vendorid;
	private String firstname, lastname, street, city, state, country, pincode, email, mobile, username, passwd;

	// constructor overloading
	public Vendor(int vendorid, String username, String passwd) {
		super();
		this.vendorid = vendorid;
		this.username = username;
		this.passwd = passwd;
	}

	public Vendor(int vendorid, String firstname, String lastname, String street, String city, String state,
			String country, String pincode, String email, String mobile, String username, String passwd) {
		this.vendorid = vendorid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.passwd = passwd;
	}

	// getters and setters
	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", firstname=" + firstname + ", lastname=" + lastname + ", street="
				+ street + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
				+ ", email=" + email + ", mobile=" + mobile + ", username=" + username + ", passwd=" + passwd + "]";
	}

}
