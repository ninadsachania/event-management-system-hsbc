package com.demo.service;

import com.demo.models.Packages;
import com.demo.models.PlanRequest;
import com.demo.models.Quotation;
import com.demo.models.Vendor;

import java.sql.SQLException;
import java.util.List;

public interface VendorService {
	boolean validateVendor(Vendor v) throws SQLException;

	boolean addPackage(Packages p) throws SQLException;

	List<PlanRequest> viewUserRequest() throws SQLException;

	boolean createQuotation(Quotation q) throws SQLException;
	
	
	static Vendor addNewVendor() {
		return null;
	}
}
