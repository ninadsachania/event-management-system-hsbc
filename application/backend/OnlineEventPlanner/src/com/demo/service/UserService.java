package com.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.demo.exceptions.InvalidNumberOfPeopleException;
import com.demo.exceptions.PlannedDateException;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.User;

public interface UserService {
	Scanner sc = new Scanner(System.in);

	boolean validateUser(User u) throws SQLException;

	User findById(int userId) throws SQLException;

	boolean registerUser(User u) throws SQLException;

	boolean updatePassword(int userid, String newPassword) throws SQLException;

	boolean addPlanRequest(PlanRequest pl) throws SQLException, InvalidNumberOfPeopleException, PlannedDateException;

	List<Quotation> viewQuotation(int uid) throws SQLException;

	boolean updateQuotationStatus(int quotid, String status) throws SQLException;
	
	public void closeConnection() throws SQLException;

	static PlanRequest getPlanRequestDetails() {
		System.out.println("Enter requestid:");
		int id = sc.nextInt();
		System.out.println("Enter fromdate(yyyy-mm-dd):");
		String fromDate = sc.next();
		System.out.println("Enter todate(yyyy-mm-dd):");
		String todate = sc.next();
		System.out.println("Enter number of people attending:");
		int np = sc.nextInt();
		System.out.println("Enter userid:");
		int uid = sc.nextInt();
		System.out.println("Enter services:");
		String services = sc.nextLine();
		PlanRequest pl = new PlanRequest(id, np, uid, fromDate, todate, services);
		return pl;
	}

	static User getUser() {
		System.out.println("Enter userid:");
		int uid = sc.nextInt();
		System.out.println("Enter firstname:");
		String fname = sc.next();
		System.out.println("Enter Lastname:");
		String lname = sc.next();
		System.out.println("Enter username:");
		String uname = sc.next();
		System.out.println("Enter password:");
		String pass = sc.next();
		System.out.println("Enter doj(yyyy-mm-dd):");
		String doj = sc.next();
		System.out.println("Enter dob(yyyy-mm-dd):");
		String dob = sc.next();
		System.out.println("Enter department(Marketing,Sales,IT):");
		String dept = sc.next();
		System.out.println("Enter email:");
		String email = sc.next();
		System.out.println("Enter mobile:");
		String mobile = sc.next();
		System.out.println("Enter location:");
		String location = sc.next();

		return new User(uid, fname, lname, uname, pass, doj, dob, dept, email, mobile, location, "non-active");
	}

}
