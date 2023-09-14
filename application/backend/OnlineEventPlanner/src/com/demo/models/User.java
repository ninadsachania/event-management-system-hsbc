package com.demo.models;

public class User {
	private int userid;
	private String firstname, lastname, username, passwd, doj, dob, dept, email, mobile, location, userstatus;

	// constructor overloading
	public User(int userid, String username, String passwd) {
		this.userid = userid;
		this.username = username;
		this.passwd = passwd;
	}

	public User(int userid, String firstname, String lastname, String username, String passwd, String doj, String dob,
			String dept, String email, String mobile, String location, String userstatus) {
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.passwd = passwd;
		this.doj = doj;
		this.dob = dob;
		this.dept = dept;
		this.email = email;
		this.mobile = mobile;
		this.location = location;
		this.userstatus = userstatus;
	}

	// getters and setters
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", passwd=" + passwd + ", doj=" + doj + ", dob=" + dob + ", dept=" + dept + ", email="
				+ email + ", mobile=" + mobile + ", location=" + location + ", userstatus=" + userstatus + "]";
	}

}
