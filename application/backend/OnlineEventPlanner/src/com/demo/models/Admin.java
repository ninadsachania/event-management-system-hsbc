package com.demo.models;

public class Admin {
	private String username, firstname, lastname, passwd, email, mobile;

	// constructor overloading
	public Admin(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}

	public Admin(String username, String firstname, String lastname, String passwd, String email, String mobile) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passwd = passwd;
		this.email = email;
		this.mobile = mobile;
	}

	// getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	@Override
	public String toString() {
		return "Admin [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", passwd="
				+ passwd + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
