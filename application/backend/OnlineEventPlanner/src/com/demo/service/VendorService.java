package com.demo.service;

import com.demo.models.Packages;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.Vendor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface VendorService {
	boolean validateVendor(Vendor v) throws SQLException;

	boolean addPackage(Packages p) throws SQLException;

	List<PlanRequest> viewUserRequest() throws SQLException;

	boolean createQuotation(Quotation q) throws SQLException;

	static Vendor addNewVendor() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Vendor ID: ");
		int vendorId = Integer.parseInt(scanner.nextLine());

		System.out.print("First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();

		System.out.print("Street: ");
		String street = scanner.nextLine();

		System.out.print("City: ");
		String city = scanner.nextLine();

		System.out.print("State: ");
		String state = scanner.nextLine();

		System.out.print("Country: ");
		String country = scanner.nextLine();

		System.out.print("Pincode: ");
		String pincode = scanner.nextLine();

		System.out.print("Email: ");
		String email = scanner.nextLine();

		System.out.print("Mobile: ");
		String mobile = scanner.nextLine();

		System.out.print("Username: ");
		String username = scanner.nextLine();

		System.out.print("Password: ");
		String passwd = scanner.nextLine();

		scanner.close();
		
		return new Vendor(vendorId, firstName, lastName, street, city, state, country, pincode, email, mobile, username, passwd);
	}
}
